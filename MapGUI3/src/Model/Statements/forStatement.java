package Model.Statements;

import Model.ProgramState;
import Model.expressions.Expression;
import Model.expressions.VariableExpression;
import Model.expressions.boolExpression;

public class forStatement implements IStatement {
    private IStatement stmt;
    private Expression expression1, expression2, expression3;
    private String var;

    public forStatement(IStatement stmt, Expression expression1, Expression expression2, Expression expression3, String var){
        this.stmt=stmt;
        this.expression1=expression1;
        this.expression2=expression2;
        this.expression3=expression3;
        this.var=var;
    }

    @Override
    public ProgramState execute(ProgramState ps) {
        IStatement s1=new CompoundStatement(
                new AssignStatement(
                        var,
                        expression1
                ),
                new WhileStatement(
                        new boolExpression(
                                new VariableExpression(var),
                                "<",
                                expression2
                        ),
                        new CompoundStatement(
                                stmt,
                                new AssignStatement(
                                        var,
                                        expression3
                                )
                        )
                )
        );
        ps.getExecutionStack().push(s1);
        return ps;
    }

    public String toString() { return "(for("+var+"="+expression1+';'+var+'<'+expression2+';'+var+'='+expression3+')'+stmt.toString()+')';}
}
