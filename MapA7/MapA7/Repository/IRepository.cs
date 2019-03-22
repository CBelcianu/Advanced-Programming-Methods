using MapA7.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Repository
{
    public interface IRepository
    {
        void SetFilepath(String FILEPATH);
        void SaveLog(ProgramState ps);
        void Add(ProgramState ps);
        ProgramState GetProgramState(int index);
    }
}
