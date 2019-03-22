package Model.Statements;

import Model.ProgramState;
import Model.expressions.ConstantExpression;
import Model.expressions.Expression;

public class doWhileStatement implements IStatement {
    private IStatement stmt;
    private Expression expr;

    public doWhileStatement(IStatement stmt, Expression expr){
        this.stmt=stmt;
        this.expr=expr;
    }

    @Override
    public ProgramState execute(ProgramState ps) {
        IStatement s1 = new IfStatement(
                expr,
                new doWhileStatement(
                        stmt,
                        expr
                ),
                new PrintStatement(
                        new ConstantExpression(0)
                )
        );
        ps.getExecutionStack().push(s1);
        ps.getExecutionStack().push(stmt);
        return ps;
    }

    public String toString() { return "(do " + stmt.toString() + "while (" + expr.toString() + "))"; }
}
