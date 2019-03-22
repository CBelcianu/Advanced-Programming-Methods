using MapA7.Controller;
using MapA7.Model;
using MapA7.Model.Expressions;
using MapA7.Model.Statements;
using MapA7.Repository;
using MapA7.View;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace MapA7
{
    class Program
    {
        static void Main(string[] args)
        {
            IStatement ex1 = new CompoundStatement(
                new AssignmentStatement(
                        "v",
                        new Model.Expressions.ConstantExpression(2)
                ),
                new PrintStatement(
                        new VariableExpression("v")
                )
            );

            IRepository repo1 = new Repositoryx();
            Controllerx ctrl1 = new Controllerx(repo1);
            ctrl1.Load(new ProgramState(new ExecutionStack(ex1), new SymbolTable(), new Output(), new FileTable(), ex1));

            IStatement ex2 = new CompoundStatement(
                new AssignmentStatement(
                        "a",
                        new ArithmeticExpression(
                                new Model.Expressions.ConstantExpression(2),
                                "*",
                                new ArithmeticExpression(
                                        new Model.Expressions.ConstantExpression(3),
                                        "*",
                                        new Model.Expressions.ConstantExpression(5)
                                )
                        )
                ),
                new CompoundStatement(
                        new AssignmentStatement(
                                "b",
                                new ArithmeticExpression(
                                        new VariableExpression("a"),
                                        "+",
                                        new Model.Expressions.ConstantExpression(1)
                                )
                        ),
                        new PrintStatement(
                                new VariableExpression("b")
                        )
                )
            );

            IRepository repo2 = new Repositoryx();
            Controllerx ctrl2 = new Controllerx(repo2);
            ctrl2.Load(new ProgramState(new ExecutionStack(ex2), new SymbolTable(), new Output(), new FileTable(), ex2));

            IStatement ex3 = new CompoundStatement(
                    new OpenRFile(
                            "var_f",
                            "test.in"
                    ),
                    new CompoundStatement(
                            new ReadFile(
                                    new VariableExpression("var_f"),
                                    "var_c"
                            ),
                            new CompoundStatement(
                                new PrintStatement(
                                        new VariableExpression("var_c")
                                ),
                                new CompoundStatement(
                                    new IfStatement(
                                            new VariableExpression("var_c"),
                                            new CompoundStatement(
                                                    new ReadFile(
                                                            new VariableExpression("var_f"),
                                                            "var_c"
                                                    ),
                                                    new PrintStatement(
                                                            new VariableExpression("var_c")
                                                    )
                                            ),
                                            new PrintStatement(
                                                    new Model.Expressions.ConstantExpression(0)
                                            )
                                    ),
                                    new CloseRFile(
                                            new VariableExpression("var_f")
                                    )
                                )
                            )
                    )
            );

            IRepository repo3 = new Repositoryx();
            Controllerx ctrl3 = new Controllerx(repo3);
            ctrl3.Load(new ProgramState(new ExecutionStack(ex3), new SymbolTable(), new Output(), new FileTable(), ex3));

            IStatement ex4 = new CompoundStatement(
                    new OpenRFile(
                            "var_f",
                            "test.in"
                    ),
                    new CompoundStatement(
                            new ReadFile(
                                    new ArithmeticExpression(
                                            new VariableExpression("var_f"),
                                            "+",
                                            new Model.Expressions.ConstantExpression(2)
                                    ),
                                    "var_c"
                            ),
                            new CompoundStatement(
                                    new PrintStatement(
                                            new VariableExpression("var_c")
                                    ),
                                    new CompoundStatement(
                                            new IfStatement(
                                                    new VariableExpression("var_c"),
                                                    new CompoundStatement(
                                                            new ReadFile(
                                                                    new VariableExpression("var_f"),
                                                                    "var_c"
                                                            ),
                                                            new PrintStatement(
                                                                    new VariableExpression("var_c")
                                                            )
                                                    ),
                                                    new PrintStatement(
                                                            new Model.Expressions.ConstantExpression(0)
                                                    )
                                            ),
                                            new CloseRFile(
                                                    new VariableExpression("var_f")
                                            )
                                    )
                            )
                    )
            );

            IRepository repo4 = new Repositoryx();
            Controllerx ctrl4 = new Controllerx(repo4);
            ctrl4.Load(new ProgramState(new ExecutionStack(ex4), new SymbolTable(), new Output(), new FileTable(), ex4));

            System.Console.Write("\nEnter the path to the log file: ");
            string filepath = System.Console.ReadLine();
            ctrl1.SetRepoFilepath(filepath);
            ctrl2.SetRepoFilepath(filepath);
            ctrl3.SetRepoFilepath(filepath);
            ctrl4.SetRepoFilepath(filepath);

            TextMenu menu = new TextMenu();
            menu.AddCommand(new ExitCommand("0", "exit"));
            menu.AddCommand(new RunCommand("1", ex1.Tostring(), ctrl1));
            menu.AddCommand(new RunCommand("2", ex2.Tostring(), ctrl2));
            menu.AddCommand(new RunCommand("3", ex3.Tostring(), ctrl3));
            menu.AddCommand(new RunCommand("4", ex4.Tostring(), ctrl4));
            menu.Show();

            //C:\Users\Catalin\source\repos\MapA7\MapA7\log.txt
        }
    }
}
