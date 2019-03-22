package Repository;

import Exceptions.CustomException;
import Model.ProgramState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private String filepath = null;
    private List<ProgramState> program;

    public Repository() {
        program = new ArrayList<>();
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void logPrgState(ProgramState ps) {
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(filepath, true)));
            logFile.println("===============================");
            logFile.println("ID: "+ps.getID());
            logFile.println(ps.getExecutionStack().toString());
            logFile.println(ps.getSymTable().toString());
            logFile.println(ps.getFileTable().toString());
            logFile.println(ps.getHeap().toString());
            logFile.println(ps.getOutput().toString());
            logFile.println("===============================");
            logFile.close();
        }
        catch (IOException exc) {
            throw new CustomException("Error during log save.");
        }
    }

    public List<ProgramState> getProgramList(){return program;}
    public void setProgramList(List<ProgramState> lst) {program=lst;}

    public void add(ProgramState ps) {
        program.add(ps);
    }

    public ProgramState getProgramState(int index) {
            return program.get(index);
    }
}
