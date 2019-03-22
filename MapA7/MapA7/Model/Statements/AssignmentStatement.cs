using MapA7.Model.Expressions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Statements
{
    public class AssignmentStatement:IStatement
    {
        private String id;
        private IExpression expression;

        public AssignmentStatement(String id, IExpression expression)
        {
            this.id = id;
            this.expression = expression;
        }

        public ProgramState Execute(ProgramState ps)
        {
            SymbolTable symbolTable = ps.GetSymbolTable();
            int result = expression.Evaluate(symbolTable);
            symbolTable.Put(id, result);
            return ps;
        }

        public String Tostring() { return id + '=' + expression.Tostring(); }
    }
}
