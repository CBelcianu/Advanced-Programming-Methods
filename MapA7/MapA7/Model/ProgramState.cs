using MapA7.Model.Statements;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model
{
    public class ProgramState
    {
        private ExecutionStack executionStack;
        private SymbolTable symbolTable;
        private Output output;
        private FileTable fileTable;
        private IStatement originalProgram;

        public ProgramState(ExecutionStack executionStack,SymbolTable symbolTable, Output output, FileTable fileTable, IStatement originalProgram)
        {
            this.executionStack = executionStack;
            this.symbolTable = symbolTable;
            this.output = output;
            this.originalProgram = originalProgram;
            this.fileTable = fileTable;
        }

        public ExecutionStack GetExecutionStack()
        {
            return executionStack;
        }

        public SymbolTable GetSymbolTable()
        {
            return symbolTable;
        }

        public Output GetOutput()
        {
            return output;
        }

        public FileTable GetFileTalbe()
        {
            return fileTable;
        }

        public void Reload()
        {
            executionStack.Clear();
            executionStack.Push(originalProgram);
            symbolTable.Clear();
            output.Clear();
            fileTable.Clear();
        }

        public String Tostring()
        {
            return executionStack.Tostring() + "\n" + symbolTable.Tostring() + "\n" + output.Tostring() + "\n";
        }
    }
}
