package Model;

import java.io.BufferedReader;
import java.util.Map;

public interface IFileTable {
    boolean exists(String filename);
    int put(Map.Entry<String, BufferedReader> pair);
    Map.Entry<String, BufferedReader> get(int key);
    void remove(int fileDescriptor);
    BufferedReader getBufferReader(int fileDescriptor);
}
