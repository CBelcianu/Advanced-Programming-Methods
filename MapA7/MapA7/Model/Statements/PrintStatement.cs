using MapA7.Model.Expressions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Statements
{
    public class PrintStatement:IStatement
    {
        private IExpression expression;

        public PrintStatement(IExpression expression) { this.expression = expression; }

        public ProgramState Execute(ProgramState ps)
        {
            Output output = ps.GetOutput();
            SymbolTable symbolTable = ps.GetSymbolTable();
            int result = expression.Evaluate(symbolTable);
            output.Add(result.ToString());
            return ps;
        }

        public String Tostring() { return "Print(" + expression.Tostring() + ')'; }
    }
}
