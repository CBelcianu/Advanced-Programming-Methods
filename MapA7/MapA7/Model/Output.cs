using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model
{
    public class Output:IList
    {
        private List<String> output;

        public Output() { this.output = new List<String>(); }

        public void Add(String element) { this.output.Add(element); }

        public void Clear() { this.output.Clear(); }

        public String Tostring()
        {
            String res = "[";
            foreach (String i in output)
            {
                res = res + i + ',';
            }
            if(res.Length>2) res=res.Remove(res.Length - 1);
            res = res + ']';
            return "Output = " + res;
        }
    }
}
