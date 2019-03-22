using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model
{
    public class FileTable : IFileTable
    {
        private Dictionary<int, Tuple<String, StreamReader>> dict;
        private int fd = 0;

        public FileTable()
        {
            dict = new Dictionary<int, Tuple<String, StreamReader>>();
        }

        public int Add(Tuple<String, StreamReader> item)
        {
            fd++;
            dict.Add(fd, item);
            return fd;
        }

        public bool Exists(String filename)
        {
            foreach (Tuple<String, StreamReader> item in dict.Values)
                if (filename == item.Item1) return true;
            return false;
        }

        public void Remove(int fd)
        {
            dict.Remove(fd);
        }

        public StreamReader GetValue(int fd)
        {
            if (dict.ContainsKey(fd))
                return dict[fd].Item2;
            return null;
        }

        public void Clear()
        {
            dict.Clear();
        }

        public String Tostring()
        {
            String str = "FileTable = {";
            String first = "";
            foreach (var item in dict)
            {
                str += first;
                str += item.Key + ": " + item.Value.Item1;
                first = ", ";
            }
            str += "}";
            return str;

        }
    }
}
