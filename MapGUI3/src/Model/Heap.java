package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Heap implements IHeap {
    private Map<Integer,Integer> dictionar;
    private int key;

    public Heap() {
        dictionar=new HashMap<>();
        key=1;
    }

    public Set<Integer> getKeys() {return dictionar.keySet();}
    public int put(int value) { dictionar.put(key,value); key=key+1; return key-1; }
    public int get(int key) { return dictionar.get(key);}
    public void set(Map<Integer,Integer> m) {dictionar=m;}
    public boolean isAllocated(int key) { return dictionar.containsKey((key)); }
    public void update(int key, int value){
        if(dictionar.containsKey(key)) dictionar.put(key,value);
    }
    public Map<Integer,Integer> getDict() {return dictionar;}
    public void clear() {dictionar.clear();}
    public String toString() { return "Heap = " + dictionar.toString(); }
}