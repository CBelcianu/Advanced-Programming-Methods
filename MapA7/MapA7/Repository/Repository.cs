using MapA7.Model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Repository
{
    public class Repositoryx:IRepository
    {
        private List<ProgramState> programs;
        private String filepath=null;

        public Repositoryx()
        {
            programs = new List<ProgramState>();
        }

        public void SetFilepath(String filepath)
        {
            this.filepath = filepath;
        }

        public void SaveLog(ProgramState ps)
        {
            FileStream fs = new FileStream(filepath, FileMode.Append, FileAccess.Write);
            StreamWriter log = new StreamWriter(fs);
            log.WriteLine("===========================");
            log.WriteLine(ps.GetExecutionStack().Tostring());
            log.WriteLine(ps.GetSymbolTable().Tostring());
            log.WriteLine(ps.GetFileTalbe().Tostring());
            log.WriteLine(ps.GetOutput().Tostring());
            log.WriteLine("===========================");
            log.Close();
        }

        public void Add(ProgramState ps)
        {
            programs.Add(ps);
        }


        public ProgramState GetProgramState(int index)
        {
            return programs[index];
        }
    }
}
