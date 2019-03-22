using MapA7.Model.Exceptions;
using MapA7.Model.Expressions;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Statements
{
    public class ReadFile:IStatement
    {
        private IExpression expr;
        private String var;

        public ReadFile(IExpression expr, String var)
        {
            this.expr = expr;
            this.var = var;
        }

        public ProgramState Execute(ProgramState ps)
        {
            SymbolTable symTable = ps.GetSymbolTable();
            FileTable fileTable = ps.GetFileTalbe();
            int fd = expr.Evaluate(symTable);
            StreamReader sr = fileTable.GetValue(fd);
            if (sr == null) throw new CustomException("The file isn't opened!.");
            try
            {
                int value = 0;
                String line = sr.ReadLine();
                if (line != null)
                    value = System.Convert.ToInt32(line);
                symTable.Put(var, value);
            }
            catch (IOException)
            {
                throw new CustomException("Reading from the file resulted in an error.");
            }
            return ps;
        }

        public String Tostring()
        {
            return "ReadFile(" + expr.Tostring() + "," + var + ")";
        }
    }
}
