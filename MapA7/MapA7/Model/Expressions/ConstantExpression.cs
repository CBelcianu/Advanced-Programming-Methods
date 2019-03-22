using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Expressions
{
    public class ConstantExpression:IExpression
    {
        private int number;

        public ConstantExpression(int number) { this.number = number; }

        public int Evaluate(SymbolTable symbolTable)
        {
            return number;
        }

        public String Tostring()
        {
            return number.ToString(); 
        }
    }
}
