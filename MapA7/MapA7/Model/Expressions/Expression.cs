using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Expressions
{
    public interface IExpression
    {
        int Evaluate(SymbolTable symbolTable);
        String Tostring();
    }
}
