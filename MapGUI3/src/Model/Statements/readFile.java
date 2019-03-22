package Model.Statements;

import Model.FileTable;
import Model.Heap;
import Model.ProgramState;
import Model.SymbolTable;
import Model.expressions.Expression;
import java.io.BufferedReader;
import java.io.IOException;

public class readFile implements IStatement {
    private Expression id;
    private String var_name;

    public readFile(Expression id, String var_name) {
        this.id = id;
        this.var_name = var_name;
    }

    public ProgramState execute(ProgramState ps){
        FileTable ft=ps.getFileTable();
        SymbolTable<String,Integer> symTable = ps.getSymTable();
        Heap ph=ps.getHeap();
        int res=id.evaluate(symTable,ph);
        BufferedReader buff = ft.getBufferReader(res);
        String line = null;
        try {
            line = buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int rez;
        if (line == null) {
            rez = 0;

        } else {
            rez = Integer.parseInt(line);
        }
        symTable.put(var_name,rez);
        return ps;
    }

    public String toString(){
        return "readFile("+id.toString()+','+var_name+')';
    }
}
