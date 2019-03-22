package Model.Statements;

import Model.ProgramState;
import Model.expressions.Expression;

public class newStatement implements IStatement {
    private String var_name;
    private Expression expr;

    public newStatement(String var_name, Expression expr){
        this.var_name=var_name;
        this.expr=expr;
    }

    public ProgramState execute(ProgramState ps){
        int eval = this.expr.evaluate(ps.getSymTable(),ps.getHeap());
        ps.getSymTable().put(var_name, ps.getHeap().put(eval));

        return ps;
    }

    public String toString(){ return "new("+var_name+','+expr.toString()+')';}
}
