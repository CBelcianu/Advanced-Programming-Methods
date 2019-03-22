package Model.Statements;

import Model.ExecutionStack;
import Model.ProgramState;
import Model.SymbolTable;
import Model.expressions.Expression;

public class IfStatement implements IStatement {
    private Expression expr;
    private IStatement thenStatement;
    private IStatement elseStatement;

    public IfStatement(Expression expr, IStatement thenStatement, IStatement elseStatement) {
        this.expr = expr;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public ProgramState execute(ProgramState ps) {
        SymbolTable<String, Integer> symTable = ps.getSymTable();
        ExecutionStack<IStatement> executionStack = ps.getExecutionStack();
        int result = expr.evaluate(symTable,ps.getHeap());
        if (result == 0) executionStack.push(elseStatement);
        else executionStack.push(thenStatement);
        return ps;
    }

    public String toString() {
        return "If " + expr.toString() + " Then " + thenStatement.toString() + " Else " + elseStatement.toString();
    }

}

