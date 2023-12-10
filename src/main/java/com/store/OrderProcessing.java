package com.store;

import java.util.ArrayList;

public class OrderProcessing {
    String ISBN;
    String quantity;
    public void processOrder(String ISBN,String quantity) throws OrderException,InvalidInputException{
        BookListing book=new BookListing();
        book.enterBook("sfsdf", "sfgdsdfg", "978-0-306-40615-7", "90", "10");
        book.enterBook("sfsdf", "sfgdsdfg", "978-0-306-40615-9", "20", "30");

        InputValidator validator=new InputValidator();
        if(validator.validateISBN(ISBN)){
            System.out.println("ISBN valid");
        }else{
            throw new InvalidInputException("ISBN book invalid");
        }
        if(book.dataList.containsKey(ISBN)){
            System.out.println("BOOK AVAILABLE");
            ArrayList<String> tmp=book.dataList.get(ISBN);
            int q=Integer.parseInt(tmp.get(4));
            int userq=Integer.parseInt(quantity);
            if(q-userq>=0){
                System.out.println("Order processed");
            }else{
                throw new OrderException("REQUIRED QUANTITY NOT AVAILABLE");
            }
        }else{
            throw new OrderException("BOOK NOT AVAILABLE");
        }

        

        
    }
}
