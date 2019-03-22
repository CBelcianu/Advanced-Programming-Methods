package Model;

import java.util.ArrayList;
import java.util.List;

public class Output<T> implements IList<T> {
    private List<T> list;

    //constructor for Output class
    public Output(){list=new ArrayList<>();}

    //function that adds an element in the list
    public void add(T element) {list.add(element);}

    public T pop() {T v=list.get(0); list.remove(v); return v;}

    //function that eliminates all the elements from the list
    public void clear() {list.clear();}

    public boolean isEmpty() { return list.isEmpty();}

    public String toString(){return "Output = " + list.toString();}
}
