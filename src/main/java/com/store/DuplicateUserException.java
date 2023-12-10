package com.store;

public class DuplicateUserException extends Exception{
    String message;
    public DuplicateUserException(String m){
        super(m);
        this.message=m;
    }

    public String getMessage(){
        return this.message;
    }
    
}
