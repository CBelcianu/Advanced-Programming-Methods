package Model.expressions;

import Model.Heap;
import Model.SymbolTable;

public abstract class Expression {

    public abstract int evaluate(SymbolTable<String, Integer> symTable, Heap ph);
    public abstract String toString();

}
