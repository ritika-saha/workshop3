package com.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookListing {
    /***
     * Book Listing:
Implement a BookListing class that maintains a list of available books in the bookstore.
Each book has a title, author, ISBN, and price.
Use regular expressions to validate the ISBN format and ensure proper input for book details.

Exception Handling:
Implement exception handling in the BookListing class for potential issues, such as invalid ISBN formats or 
missing book details.
Use custom exception classes to convey specific error conditions.

     */
    String title,author,ISBN,price,quantity;
     public Map<String,ArrayList<String>> dataList;
     public BookListing(){
        dataList=new HashMap<>();
     }

     public void  enterBook(String title,String author,String ISBN,String price,String quantity) throws InvalidInputException{
        InputValidator validator=new InputValidator();
        if(validator.validateBookEntry(title)){
            this.title=title;
        }else{
            throw new InvalidInputException("Empty title exception");
        }

        if(validator.validateISBN(ISBN)){
            this.ISBN=ISBN;
        }else{
            throw new InvalidInputException("Wrong ISBN entered");
        }

        if(validator.validateBookEntry(author)){
            this.author=author;
        }else{
            throw new InvalidInputException("Empty author exception");
        }

        if(validator.validateBookEntry(price)){
            this.price=price;
        }else{
            throw new InvalidInputException("Empty price exception");
        }

        if(validator.validateBookEntry(quantity)){
            this.quantity=quantity;
        }else{
            throw new InvalidInputException("Empty quantity exception");
        }

        ArrayList<String> data=new ArrayList<>();
        data.add(title);
        data.add(author);
        data.add(ISBN);
        data.add(price);
        data.add(quantity);
        dataList.put(ISBN, data);

     }
}
