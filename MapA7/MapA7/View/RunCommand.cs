using MapA7.Controller;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.View
{
    public class RunCommand:Command
    {
        private Controllerx ctr;

        public RunCommand(String key, String desc, Controllerx ctr) : base(key, desc)
        {
            this.ctr = ctr;
        }
       
        public override void Execute()
        {
            ctr.AllSteps(0, false);
        }
    }
}
