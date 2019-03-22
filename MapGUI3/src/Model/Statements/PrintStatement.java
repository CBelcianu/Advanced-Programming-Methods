package Model.Statements;

import Model.Heap;
import Model.Output;
import Model.ProgramState;
import Model.expressions.Expression;

public class PrintStatement implements IStatement {
    private Expression expr;

    public PrintStatement(Expression expr) {
        this.expr = expr;
    }

    public ProgramState execute(ProgramState ps) {
        Output<Integer> output = ps.getOutput();
        Heap ph=ps.getHeap();
        int result = expr.evaluate(ps.getSymTable(),ph);
        output.add(result);
        return ps;
    }

    public String toString() {
        return "Print(" + expr.toString() + ")";
    }

}
