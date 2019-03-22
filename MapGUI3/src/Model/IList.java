package Model;

public interface IList<T> {
    void add(T element);
    void clear();
    T pop();
    boolean isEmpty();
    String toString();
}
