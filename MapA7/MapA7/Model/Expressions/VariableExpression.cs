using MapA7.Model.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Expressions
{
    public class VariableExpression:IExpression
    {
        private String id;

        public VariableExpression(String id) { this.id = id; }

        public int Evaluate(SymbolTable symbolTable)
        {
            if (symbolTable.ContainsKey(id)) return symbolTable.Get(id);
            else throw new CustomException("Undefined variable!");
        }

        public String Tostring() { return id; }
    }
}
