package Model.Statements;

import Model.ProgramState;

public interface IStatement {

    ProgramState execute(ProgramState ps);
    String toString();

}
