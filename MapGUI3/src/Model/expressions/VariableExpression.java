package Model.expressions;

import Exceptions.UndefinedVariableException;
import Model.Heap;
import Model.SymbolTable;
import Exceptions.CustomException;

public class VariableExpression extends Expression {

    private String id;

    public VariableExpression(String id) {
        this.id = id;
    }

    public int evaluate(SymbolTable<String, Integer> symTable, Heap ph) {
        if (symTable.hasKey(id)) return symTable.get(id);
        else throw new UndefinedVariableException();
    }

    public String toString() {
        return id;
    }

}
