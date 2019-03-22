package Model.expressions;

import Exceptions.InvalidOperationException;
import Model.Heap;
import Model.SymbolTable;
import Exceptions.CustomException;
import Exceptions.DivisionByZeroException;

public class ArithmeticExpression extends Expression {

    private Expression expr1;
    private Expression expr2;
    private char operation;

    public ArithmeticExpression(Expression expr1, char operation, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.operation = operation;
    }

    public int evaluate(SymbolTable<String, Integer> symTable, Heap ph) {
        if (operation == '+')
            return expr1.evaluate(symTable,ph) + expr2.evaluate(symTable,ph);
        else if (operation == '-')
            return expr1.evaluate(symTable,ph) - expr2.evaluate(symTable,ph);
        else if (operation == '*')
            return expr1.evaluate(symTable,ph) * expr2.evaluate(symTable,ph);
        else if (operation == '/') {
            int e1 = expr1.evaluate(symTable,ph);
            int e2 = expr2.evaluate(symTable,ph);
            if (e2 == 0) throw new DivisionByZeroException();
            return e1 / e2;
        }
        else
            throw new InvalidOperationException();
    }

    public String toString() {
        return "(" + expr1.toString() + operation + expr2.toString() + ")";
    }

}

