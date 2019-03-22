package Model.Statements;

import Model.ProgramState;
import Model.ExecutionStack;

public class CompoundStatement implements IStatement {
    private IStatement firstStatement;
    private IStatement secondStatement;

    public CompoundStatement(IStatement firstStatement, IStatement secondStatement) {
        this.firstStatement = firstStatement;
        this.secondStatement = secondStatement;
    }

    public ProgramState execute(ProgramState ps) {
        ExecutionStack<IStatement> executionStack = ps.getExecutionStack();
        executionStack.push(secondStatement);
        executionStack.push(firstStatement);
        return ps;
    }

    public String toString() {
        return firstStatement.toString() + "; " + secondStatement.toString();
    }
}
