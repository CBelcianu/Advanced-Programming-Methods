package Model;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable<K,V> implements IDictionary<K,V> {
    private Map<K,V> dictionar;

    //constructor for the SymbolTable class
    public SymbolTable() {dictionar=new HashMap<>();}

    //function that adds a pair(key, value) to the SymbolTable
    public void put(K key,V value){dictionar.put(key,value);}

    /*
        function that verifies if a given key exists in the SymbolTable
     */
    public boolean hasKey(K key){return dictionar.containsKey(key);}

    //function that returns the value from the pair(key, value) where the key is given
    public V get(K key){return dictionar.get(key);}

    //function that clears the SymbolTable
    public void clear(){dictionar.clear();}

    public Map<K,V> getContent() { return dictionar;}

    public void clone(SymbolTable nw){
        Map<K,V> cl = nw.getContent();
        for (K key : cl.keySet()) {
            dictionar.put(key, cl.get(key));
        }
    }

    public String toString(){return "SymbolTable = " + dictionar.toString();}
}
