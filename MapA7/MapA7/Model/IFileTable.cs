using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model
{
    public interface IFileTable
    {
        int Add(Tuple<String, StreamReader> item);
        void Remove(int fd);
        bool Exists(String filename);
        StreamReader GetValue(int fd);
        void Clear();
    }
}
