using MapA7.Model.Statements;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model
{
    public interface IStack
    {
        void Push(IStatement st);
        IStatement Pop();
        bool IsEmpty();
        void Clear();
        String ToString();
    }
}
