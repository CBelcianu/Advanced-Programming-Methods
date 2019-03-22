package Exceptions;

public class UndefinedVariableException extends RuntimeException {
    public UndefinedVariableException(){
        super("Undefined variable!");
    }
}
