package Model.Statements;

import Model.Heap;
import Model.ProgramState;
import Model.SymbolTable;
import Model.expressions.Expression;

public class wH implements IStatement {
    private String varName;
    private Expression expr;

    public wH(String varName, Expression expr){
        this.varName=varName;
        this.expr=expr;
    }

    public ProgramState execute(ProgramState ps){
        Heap ph=ps.getHeap();
        SymbolTable<String,Integer> symTable=ps.getSymTable();
        int addr=symTable.get(varName);
        int val=expr.evaluate(symTable,ph);
        ph.update(addr,val);
        return ps;
    }

    public String toString(){ return "wH("+varName+','+expr.toString()+')';}
}
