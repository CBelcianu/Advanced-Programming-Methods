package Model.Statements;

import Model.ExecutionStack;
import Model.ProgramState;
import Model.SymbolTable;

public class forkStatement implements IStatement {
    private IStatement prg;

    public forkStatement(IStatement prg){this.prg=prg;}

    public ProgramState execute(ProgramState ps){
        ExecutionStack exeStk3= new ExecutionStack<>(prg);
        SymbolTable sy= new SymbolTable();
        sy.clone(ps.getSymTable());
        ProgramState newP=new ProgramState(exeStk3,sy,ps.getOutput(),prg,ps.getFileTable(),ps.getHeap(),ps.getID()*10);

        return newP;
    }

    public String toString(){return "fork("+prg.toString()+')';}
}
