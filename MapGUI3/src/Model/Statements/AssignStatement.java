package Model.Statements;

import Model.expressions.Expression;
import Model.ProgramState;
import Model.SymbolTable;

public class AssignStatement implements IStatement {
    private String var;
    private Expression expr;

    public AssignStatement(String var, Expression expr) {
        this.var = var;
        this.expr = expr;
    }

    public ProgramState execute(ProgramState ps) {
        SymbolTable<String, Integer> symTable = ps.getSymTable();
        int result = expr.evaluate(symTable,ps.getHeap());
        symTable.put(var, result);
        return ps;
    }

    public String toString() {
        return var + "=" + expr.toString();
    }

}
