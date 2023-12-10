package com.store;

public class InvalidInputException extends Exception{

    private String message;
    public InvalidInputException(String m)
    {
        super(m);
        this.message=m;
    }

    public String getMessage(){
        return this.message;
    }
}
