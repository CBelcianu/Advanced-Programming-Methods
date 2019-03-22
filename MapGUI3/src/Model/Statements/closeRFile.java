package Model.Statements;

import Model.FileTable;
import Model.ProgramState;
import Model.SymbolTable;
import Model.expressions.Expression;

import java.io.BufferedReader;
import java.io.IOException;

public class closeRFile implements IStatement {
    private Expression id;

    public closeRFile(Expression id){ this.id=id;}

    public ProgramState execute(ProgramState ps){
        FileTable ft=ps.getFileTable();
        SymbolTable<String,Integer> symTable = ps.getSymTable();
        int res=id.evaluate(symTable,ps.getHeap());
        BufferedReader buff = ft.getBufferReader(res);
        try {
            buff.close();
            ft.remove(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public String toString(){
        return "closeRFile(" + id.toString()+")" ;
    }
}
