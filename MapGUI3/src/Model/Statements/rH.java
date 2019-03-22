package Model.Statements;

import Model.Heap;
import Model.ProgramState;
import Model.SymbolTable;
import Model.expressions.Expression;

public class rH extends Expression {
    private String varName;

    public rH(String varName){this.varName=varName;}

    public int evaluate(SymbolTable<String,Integer> symTable, Heap ph){
        int addr=ph.get(symTable.get(varName));
        //int val=ph.get(addr);
        return addr;
    }

    public String toString(){ return "rH("+varName+")";}
}
