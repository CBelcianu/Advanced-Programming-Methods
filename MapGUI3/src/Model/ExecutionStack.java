package Model;

import java.util.Stack;

public class ExecutionStack<T> implements IStack<T> {
    private Stack<T> stack;

    /*
        Constructor for ExecutionStack class
        input: T element
     */
    public ExecutionStack(T element) {

        stack = new Stack<>();
        stack.push(element);

    }

    public ExecutionStack(){
        stack = new Stack<>();
    }

    //function that pushes an element on the stack
    public void push(T element) {
        stack.push(element);
    }

    //function that pops an element from the stack
    public T pop() {
        return stack.pop();
    }

    /*
        Function that verifies if the stack is empty
        output: true, if the stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return stack.empty();
    }

    //function that eliminates all the elements from the stack
    void clear() {
        stack.clear();
    }

    public String toString() {
        return "ExecutionStack = " + stack.toString();
    }
}
