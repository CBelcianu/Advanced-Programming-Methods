package Model;

import Exceptions.CustomException;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileTable implements IFileTable {
    private Map<Integer,Map.Entry<String, BufferedReader>> dictionar;
    private Integer key;

    public FileTable() {
        dictionar = new HashMap<>();
        key=1;
    }
    public boolean exists(String filename){
        for (Map.Entry<String, BufferedReader> tuple: dictionar.values())
            if (filename.equals(tuple.getKey())) return true;
        return false;
    }
    public Map.Entry<String, BufferedReader> get(int key){
        return dictionar.get(key);
    }
    public Set<Map.Entry<Integer,Map.Entry<String,BufferedReader>>> entrySet(){
        return dictionar.entrySet();
    }
    public int put(Map.Entry<String, BufferedReader> pair){ dictionar.put(key,pair); key=key+1; return key-1;}
    public void remove(int fileDescriptor){dictionar.remove(fileDescriptor);}
    public BufferedReader getBufferReader(int fileDescriptor) {
        if(!dictionar.containsKey(fileDescriptor))
            throw new CustomException("Invalid file descriptor\n");
        else
            return dictionar.get(fileDescriptor).getValue();
    }
    public Map<Integer,Map.Entry<String, BufferedReader>> getContent() {return dictionar;}
    public void clear(){dictionar.clear();}
    public String toString(){return "FileTable = " + dictionar.toString();}
}

