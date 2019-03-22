using MapA7.Model.Statements;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model
{
    public class ExecutionStack:IStack
    {
        private Stack<IStatement> statements;

        public ExecutionStack(IStatement statement)
        {
            this.statements = new Stack<IStatement>();
            this.statements.Push(statement);
        }

        public void Push(IStatement statement)
        {
            this.statements.Push(statement);
        }

        public IStatement Pop()
        {
            return this.statements.Pop();
        }

        public bool IsEmpty()
        {
            return this.statements.Count() == 0;
        }

        public void Clear()
        {
            this.statements.Clear();
        } 

        public String Tostring()
        {
            String res = "[";
            foreach (IStatement i in statements)
            {
                res = res + i.Tostring();
            }
            res = res + ']';
            return "ExecutionStack = " + res;
        }
    }
}
