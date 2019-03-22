package Model;

import java.util.Map;
import java.util.Set;

public interface IHeap {
    boolean isAllocated(int key);
    int put(int value);
    int get(int key);
    void set(Map<Integer,Integer> m);
    void update(int key, int value);
    Map<Integer,Integer> getDict();
    void clear();
    Set<Integer> getKeys();
    String toString();
}
