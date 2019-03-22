using MapA7.Model.Expressions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Statements
{
    public class IfStatement:IStatement
    {
        private IExpression expression;
        private IStatement sthen;
        private IStatement selse;

        public IfStatement(IExpression expression, IStatement sthen, IStatement selse)
        {
            this.expression = expression;
            this.sthen = sthen;
            this.selse = selse;
        }

        public ProgramState Execute(ProgramState ps)
        {
            SymbolTable symbolTable = ps.GetSymbolTable();
            ExecutionStack executionStack = ps.GetExecutionStack();
            int result = expression.Evaluate(symbolTable);
            if (result == 0) executionStack.Push(selse);
            else executionStack.Push(sthen);
            return ps;
        }

        public String Tostring() { return "if " + expression.Tostring() + " then " + sthen.Tostring() + " else " + selse.Tostring(); }
    }
}
