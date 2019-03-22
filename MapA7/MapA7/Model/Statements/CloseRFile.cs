using MapA7.Model.Exceptions;
using MapA7.Model.Expressions;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Statements
{
    public class CloseRFile:IStatement
    {
        private IExpression expr;

        public CloseRFile(IExpression expr)
        {
            this.expr = expr;
        }

        public ProgramState Execute(ProgramState ps)
        {
            SymbolTable symTable = ps.GetSymbolTable();
            FileTable fileTable = ps.GetFileTalbe();
            int fd = expr.Evaluate(symTable);
            StreamReader sr = fileTable.GetValue(fd);
            if (sr == null) throw new CustomException("The file ins't opened!.");
            try
            {
                sr.Close();
                fileTable.Remove(fd);
            }
            catch (IOException)
            {
                throw new CustomException("Closing of the file resulted in an error.");
            }
            return ps;
        }

        public String Tostring()
        {
            return "CloseRFile(" + expr.Tostring() + ")";
        }
    }
}
