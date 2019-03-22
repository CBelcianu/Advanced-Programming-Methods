using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model
{
    public interface IDictionary
    {
        void Put(String key, int value);
        bool ContainsKey(String key);
        int Get(String key);
        Dictionary<String, int> GetContent();
        void Clear();
        String Tostring();
    }
}
