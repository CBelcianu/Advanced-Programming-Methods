package Model.expressions;

import Model.Heap;
import Model.SymbolTable;

public class ConstantExpression extends Expression {

    private int number;

    public ConstantExpression(int number) {
        this.number = number;
    }

    public int evaluate(SymbolTable<String, Integer> symTable, Heap ph) {
        return number;
    }

    public String toString() {
        return Integer.toString(number);
    }

}
