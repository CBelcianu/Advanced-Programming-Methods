using MapA7.Model.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Expressions
{
    public class ArithmeticExpression:IExpression
    {
        private IExpression expression1;
        private IExpression expression2;
        private String op;

        public ArithmeticExpression(IExpression expression1, String op, IExpression expression2)
        {
            this.expression1 = expression1;
            this.expression2 = expression2;
            this.op = op;
        }

        public int Evaluate(SymbolTable symbolTable)
        {
            switch (op)
            {
                case "+":
                    return expression1.Evaluate(symbolTable) + expression2.Evaluate(symbolTable);
                case "-":
                    return expression1.Evaluate(symbolTable) - expression2.Evaluate(symbolTable);
                case "*":
                    return expression1.Evaluate(symbolTable) * expression2.Evaluate(symbolTable);
                case "/":
                    int e1 = expression1.Evaluate(symbolTable);
                    int e2 = expression2.Evaluate(symbolTable);
                    if (e2 != 0) return e1 / e2;
                    else throw new CustomException("Division by zero!");
            }
            throw new CustomException("Invalid operation!");
        }

        public String Tostring() { return expression1.Tostring() + op + expression2.Tostring(); }
    }
}
