package Repository;

import Model.ProgramState;

import java.util.List;

public interface IRepository {

    void add(ProgramState ps);
    ProgramState getProgramState(int index);
    void setFilepath(String FILEPATH);
    void logPrgState(ProgramState ps);
    List<ProgramState> getProgramList();
    void setProgramList(List<ProgramState> prgList);
}
