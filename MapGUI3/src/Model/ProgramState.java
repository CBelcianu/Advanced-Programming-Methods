package Model;

import Exceptions.CustomException;
import Model.Statements.IStatement;
import Model.Statements.forkStatement;

public class ProgramState {

    private ExecutionStack<IStatement> executionStack;
    private SymbolTable<String, Integer> symTable;
    private Output<Integer> output;
    private IStatement originalProgram;
    private FileTable fileTable;
    private Heap ph;
    private int ID;

    /*
        Constructor for ProgramState class
        input: ExecutionStack, SymbolTable, Output, IStatement
     */
    public ProgramState(ExecutionStack<IStatement> executionStack, SymbolTable<String, Integer> symTable, Output<Integer> output, IStatement originalProgram, FileTable fileTable, Heap ph, int ID) {
        this.originalProgram = originalProgram;
        this.executionStack = executionStack;
        this.symTable = symTable;
        this.output = output;
        this.fileTable=fileTable;
        this.ph=ph;
        this.ID=ID;
    }

    public boolean isNotCompleted(){ return !executionStack.isEmpty();}

    public ProgramState OneStep(){
        if(executionStack.isEmpty()) return this;
        IStatement st=executionStack.pop();
        return st.execute(this);
    }

    public ExecutionStack<IStatement> getExecutionStack() {
        return executionStack;
    }

    public SymbolTable<String, Integer> getSymTable() {
        return symTable;
    }

    public Output<Integer> getOutput() {
        return this.output;
    }

    public FileTable getFileTable() { return this.fileTable;}

    public Heap getHeap() { return this.ph; }

    public int getID() {return ID;}

    //function that clears the stack, symbolTable and Output, and pushes back the original program on the stack
    public void reload() {
        executionStack.clear();
        executionStack.push(originalProgram);
        symTable.clear();
        output.clear();
        fileTable.clear();
        ph.clear();
    }

    public  boolean isOK(){
        IStatement cv=this.executionStack.pop();
        if(cv instanceof forkStatement) {
            this.executionStack.push(cv);
            return true;

        }
        else{
            this.executionStack.push(cv);
            return false;
        }
    }

    public String toString() {
        return "ID: " + ID + "\n" + executionStack.toString() + "\n" + symTable.toString() + "\n" + ph.toString() + "\n" + output.toString() + "\n";
    }

}
