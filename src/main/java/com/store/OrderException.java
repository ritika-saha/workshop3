package com.store;

public class OrderException extends Exception{
    private String message;
    public OrderException(String m)
    {
        super(m);
        this.message=m;
    }

    public String getMessage(){
        return this.message;
    }
}
