using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Statements
{
    public interface IStatement
    {
        ProgramState Execute(ProgramState ps);
        String Tostring();
    }
}
