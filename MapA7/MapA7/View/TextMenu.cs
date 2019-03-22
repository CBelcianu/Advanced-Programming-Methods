using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.View
{
    class TextMenu
    {
        private Dictionary<String, Command> commands;

        public TextMenu()
        {
            commands = new Dictionary<String,Command>();
        }

        public void AddCommand(Command c)
        {
            commands.Add(c.GetKey(), c);
        }

        private void PrintMenu()
        {
            foreach (Command com in commands.Values)
            {
                String line = com.GetKey() + " : " + com.GetDescription();
                Console.WriteLine(line);
            }
        }
        public void Show()
        {
            while (true)
            {
                PrintMenu();
                Console.WriteLine("Input the option: ");
                String key = Console.ReadLine();
                Command com;
                commands.TryGetValue(key,out com);
                if (com == null)
                {
                    Console.WriteLine("Invalid Option");
                    continue;
                }
                com.Execute();
            }
        }
    }
}
