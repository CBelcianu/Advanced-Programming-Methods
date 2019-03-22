package Model.expressions;

import Exceptions.CustomException;
import Model.Heap;
import Model.SymbolTable;

public class boolExpression extends Expression {
    private Expression expr1;
    private Expression expr2;
    private String symbol;

    public boolExpression(Expression expr1, String symbol, Expression expr2){
        this.expr1=expr1;
        this.expr2=expr2;
        this.symbol=symbol;
    }

    public int evaluate(SymbolTable<String, Integer> symTable, Heap ph) {
        switch (symbol) {
            case "<":
                if (expr1.evaluate(symTable, ph) < expr2.evaluate(symTable, ph)) return 1;
                else return 0;
            case "<=":
                if (expr1.evaluate(symTable, ph) <= expr2.evaluate(symTable, ph)) return 1;
                else return 0;
            case "==":
                if (expr1.evaluate(symTable, ph) == expr2.evaluate(symTable, ph)) return 1;
                else return 0;
            case "!=":
                if (expr1.evaluate(symTable, ph) != expr2.evaluate(symTable, ph)) return 1;
                else return 0;
            case ">":
                if (expr1.evaluate(symTable, ph) > expr2.evaluate(symTable, ph)) return 1;
                else return 0;
            case ">=":
                if (expr1.evaluate(symTable, ph) >= expr2.evaluate(symTable, ph)) return 1;
                else return 0;
            default:
                throw new CustomException("invalid symbol!");
        }
    }

    public String toString(){ return "(" + expr1.toString() + symbol + expr2.toString() + ")";}
}
