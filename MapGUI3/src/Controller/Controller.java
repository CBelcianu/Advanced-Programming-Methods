package Controller;

import Exceptions.CustomException;
import Exceptions.DivisionByZeroException;
import Exceptions.InvalidOperationException;
import Exceptions.UndefinedVariableException;
import Model.*;
import Model.Statements.IStatement;
import Model.Statements.closeRFile;
import Model.expressions.VariableExpression;
import Repository.*;
import sample.AlertBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Controller {
    private IRepository repo;
    private ExecutorService executor;
    private String originalProgram;

    public String getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(String originalProgram) {
        this.originalProgram = originalProgram;
    }

    public ExecutorService getExecutor() {return executor;}

    public IRepository getRepo() { return repo; }

    public Controller(IRepository repo) {
        this.repo = repo;
        executor = Executors.newFixedThreadPool(2);
    }

    public List<ProgramState> getPrograms() {return repo.getProgramList();}

    public void setPrograms(List<ProgramState> lps) { repo.setProgramList(lps);}

    public void load(ProgramState ps) {
        repo.add(ps);
    }

    public Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer,Integer> heap){
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void closeFiles(Map<String, Integer> symTable, Map<Integer, Map.Entry<String, BufferedReader>> fileTable, ProgramState ps) {
        Map<String, Integer> files = symTable.entrySet().stream().filter(
                e->fileTable.containsKey(e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (String var: files.keySet()) {
            IStatement stm = new closeRFile(new VariableExpression(var));
            try {
                stm.execute(ps);
            }
            catch (RuntimeException exc) {
                //
            }
            finally {
                repo.logPrgState(ps);
            }
        }
    }

    public void fancyexehelp1(){
        executor = Executors.newFixedThreadPool(2);
        List<ProgramState>  prgList=removeCompletedPrg(repo.getProgramList());
    }

    public void fancyexehelp2(List<ProgramState> prgList){
        executor.shutdownNow();
        List<ProgramState> tmpList= repo.getProgramList();
        tmpList.forEach(ps-> closeFiles(ps.getSymTable().getContent(),ps.getFileTable().getContent(),ps));
        repo.setProgramList(prgList);
    }

    public void allSteps(int index, boolean eachExecution) throws InterruptedException {
        executor = Executors.newFixedThreadPool(2);
        List<ProgramState>  prgList=removeCompletedPrg(repo.getProgramList());
        while(prgList.size()>0){
            prgList.forEach(ps->
            ps.getHeap().set(conservativeGarbageCollector(
                    ps.getSymTable().getContent().values(),
                    ps.getHeap().getDict())));
            oneStepForAllPrg(prgList);
            for(ProgramState prg : prgList){
                System.out.println(prg.toString());
            }
            prgList=removeCompletedPrg(repo.getProgramList());
        }

        executor.shutdownNow();
        List<ProgramState> tmpList= repo.getProgramList();
        tmpList.forEach(ps-> closeFiles(ps.getSymTable().getContent(),ps.getFileTable().getContent(),ps));
        repo.setProgramList(prgList);
    }

    public void setRepoFilepath(String filepath) {
        repo.setFilepath(filepath);
    }

    public void oneStep(ProgramState ps,ExecutionStack<IStatement> es, boolean eachExecution) {
        try {
            IStatement statement = es.pop();
            statement.execute(ps);
            ps.getHeap().set(conservativeGarbageCollector(
                    ps.getSymTable().getContent().values(),
                    ps.getHeap().getDict()));
            repo.logPrgState(ps);
            if (eachExecution)
                System.out.println(ps.toString());
        } catch (DivisionByZeroException | InvalidOperationException | UndefinedVariableException | CustomException exc) {
            throw exc;
        }
    }

    public List<ProgramState> removeCompletedPrg(List<ProgramState> inPrgList){
        return inPrgList.stream().filter(ProgramState::isNotCompleted).collect(Collectors.toList());
    }

    public void oneStepForAllPrg(List<ProgramState> prgList) throws InterruptedException {
        int ok=1;
        for(ProgramState prg : prgList){
            if(!prg.isOK()) ok=0;
        }
        List<Callable<ProgramState>>callList=prgList.stream()
                .map((ProgramState p)->(Callable<ProgramState>)(p::OneStep)).collect(Collectors.toList());
        List<ProgramState> newPrgList=null;

        try {
            newPrgList = executor.invokeAll(callList).stream().map(future -> {
                try {
                    return future.get();
                } catch (InterruptedException | ExecutionException e) {
                    AlertBox.display("Exception", e.getMessage());
                }
                return null;
            }).filter(Objects::nonNull).collect(Collectors.toList());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    if(ok==1) prgList.addAll(newPrgList);
    prgList.forEach((prg->repo.logPrgState(prg)));
    repo.setProgramList(prgList);
    }

    public ProgramState getProgramStateCtrl(int index){
        ProgramState ps = repo.getProgramState(index);
        return ps;
    }

}
