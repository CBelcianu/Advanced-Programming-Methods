package Exceptions;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(){
        super("Invalid Operation");
    }
}
