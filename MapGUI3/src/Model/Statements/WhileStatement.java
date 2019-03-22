package Model.Statements;

import Model.ProgramState;
import Model.expressions.Expression;

public class WhileStatement implements IStatement {
    private Expression expr;
    private IStatement stmt;

    public WhileStatement(Expression expr, IStatement stmt){
        this.expr=expr;
        this.stmt=stmt;
    }

    public ProgramState execute(ProgramState ps){
        if(expr.evaluate(ps.getSymTable(),ps.getHeap())==0){
            //ps.getExecutionStack().pop();
            return ps;
        }
        else{
            ps.getExecutionStack().push(this);
            ps.getExecutionStack().push(stmt);
        }
        return ps;
    }

    public String toString(){return "(while"+expr.toString()+' '+stmt.toString()+')';}
}
