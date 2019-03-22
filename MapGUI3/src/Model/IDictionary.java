package Model;

import java.util.Map;

public interface IDictionary<K,V> {
    void put(K key, V value);
    boolean hasKey(K key);
    V get(K key);
    Map<K,V> getContent();
    void clear();
    String toString();
}
