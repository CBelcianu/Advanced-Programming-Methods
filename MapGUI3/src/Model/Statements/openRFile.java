package Model.Statements;

import Model.ProgramState;
import Model.FileTable;
import Model.SymbolTable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;

public class openRFile implements IStatement {
    private String id;
    private String filename;


    public openRFile(String id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    public ProgramState execute(ProgramState ps) {
        FileTable ft=ps.getFileTable();
        SymbolTable<String, Integer> symTable = ps.getSymTable();
        if(ft.exists(filename))
            return ps;
        try{
            BufferedReader buff = new BufferedReader(new FileReader(filename));
            int fd = ft.put(new AbstractMap.SimpleEntry<>(filename, buff));
            symTable.put(id, fd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public String toString(){
        return "openRFile(" +id+','+filename+")";
    }
}
