package Model.Statements;

import Model.ProgramState;
import Model.expressions.Expression;

public class condAssignStatement implements IStatement {
    private String var;
    private Expression expression1;
    private Expression expression2;
    private Expression expression3;

    public condAssignStatement(String var,Expression expression1, Expression expression2, Expression expression3){
        this.var=var;
        this.expression1=expression1;
        this.expression2=expression2;
        this.expression3=expression3;
    }

    @Override
    public ProgramState execute(ProgramState ps) {
        IStatement s1= new IfStatement(
                expression1,
                new AssignStatement(var,expression2),
                new AssignStatement(var,expression3)
        );
        ps.getExecutionStack().push(s1);
        return ps;
    }

    public String toString(){return var+'='+expression1.toString()+'?'+expression2.toString()+':'+expression3.toString(); }
}
