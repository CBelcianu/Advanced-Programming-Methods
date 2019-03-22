using MapA7.Model;
using MapA7.Model.Exceptions;
using MapA7.Model.Statements;
using MapA7.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Controller
{
    public class Controllerx
    {
        private IRepository repo;

        public Controllerx(IRepository repo)
        {
            this.repo = repo;
        }

        public void SetRepoFilepath(String filepath)
        {
            repo.SetFilepath(filepath);
        }

        public void Load(ProgramState ps)
        {
            repo.Add(ps);
        }

        public void OneStep(ProgramState ps, ExecutionStack es, bool eachExecution)
        {
            try
            {
                IStatement statement = es.Pop();
                statement.Execute(ps);
                if (eachExecution)
                    Console.WriteLine(ps.Tostring());
            }
            catch (CustomException exc)
            {
                throw exc;
            }
        }

        public void AllSteps(int index, bool eachExecution)
        {

            bool isStopped = false;

            ProgramState ps = repo.GetProgramState(index);

            Console.WriteLine(ps.Tostring());

            ExecutionStack executionStack = ps.GetExecutionStack();


            while (!executionStack.IsEmpty())
            {
                try
                {
                    OneStep(ps, executionStack, eachExecution);
                    repo.SaveLog(ps);
                }
                catch (CustomException exc)
                {
                    Console.WriteLine(exc.Message);
                    isStopped = true;
                    break;
                }

            }
            if (!eachExecution && !isStopped)
                Console.WriteLine(ps.Tostring());
            ps.Reload();

        }

        public ProgramState GetProgramStateCtrl(int index)
        {
            ProgramState ps = repo.GetProgramState(index);
            return ps;
        }
    }
}
