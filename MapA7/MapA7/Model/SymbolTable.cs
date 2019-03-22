using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model
{
    public class SymbolTable:IDictionary
    {
        private Dictionary<String, int> dict;

        public SymbolTable() { this.dict = new Dictionary<String, int>(); }

        public void Put(String key, int value) {
            if (this.dict.ContainsKey(key))
                this.dict[key] = value;
            else
                this.dict.Add(key, value);
        }

        public bool ContainsKey(String key) { return this.dict.ContainsKey(key); }

        public int Get(String key)
        {
            this.dict.TryGetValue(key, out int res);
            return res;
        }

        public Dictionary<String, int> GetContent() { return this.dict; }

        public void Clear() { this.dict.Clear(); }

        public String Tostring()
        {
            String res = "[";
            foreach (KeyValuePair<String,int> i in dict)
            {
                res =res + i.Key+'='+i.Value.ToString()+',';
            }
            if (res.Length > 2) res = res.Remove(res.Length - 1);
            res = res + ']';
            return "SymbolTable = " + res;
        }
    }
}
