package Model;

public interface IStack<T> {
    void push(T statement);
    T pop();
    boolean isEmpty();
    String toString();
}
