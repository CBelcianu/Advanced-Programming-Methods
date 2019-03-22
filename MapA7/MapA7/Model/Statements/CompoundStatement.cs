using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Statements
{
    public class CompoundStatement:IStatement
    {
        private IStatement left;
        private IStatement right;

        public CompoundStatement(IStatement left, IStatement right)
        {
            this.left = left;
            this.right = right;
        }

        public ProgramState Execute(ProgramState ps)
        {
            ExecutionStack executionStack = ps.GetExecutionStack();
            executionStack.Push(right);
            executionStack.Push(left);
            return ps;
        }

        public String Tostring() { return left.Tostring() + ';' + right.Tostring(); }
    }
}
