using MapA7.Model.Exceptions;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Statements
{
    public class OpenRFile:IStatement
    {
        private String var;
        private String filename;

        public OpenRFile(String var, String filename)
        {
            this.var = var;
            this.filename = filename;
        }

        public ProgramState Execute(ProgramState ps)
        {
            SymbolTable symTable = ps.GetSymbolTable();
            FileTable fileTable = ps.GetFileTalbe();
            if (fileTable.Exists(filename))
                throw new CustomException("File " + filename + " is already opened.");
            try
            {
                StreamReader sr = new StreamReader(new FileStream(filename, FileMode.Open, FileAccess.Read));
                int fd = fileTable.Add(new System.Tuple<string, StreamReader>(filename, sr));
                symTable.Put(var, fd);
            }
            catch (IOException)
            {
                throw new CustomException("Opening of the file " + filename + " resultet int an error.");
            }
            return ps;
        }

        public String Tostring()
        {
            return "OpenRFile(" + var + ", " + filename + ")";
        }
    }
}
