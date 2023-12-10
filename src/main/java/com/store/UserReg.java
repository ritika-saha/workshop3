package com.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserReg {
   
    private Set<String> usernames;
    private Map<String,ArrayList<String>> dataList;
   
    
    public UserReg(){
        this.usernames=new HashSet<>();
        this.dataList=new HashMap<>();
    }

    public void registerUser(String username,String password,String email,String phone) throws DuplicateUserException, InvalidInputException{
        if (!usernames.contains(username)) {
            // User does not exist, proceed with registration
            usernames.add(username);
        
            ArrayList<String> currentData = new ArrayList<>();
            InputValidator validator = new InputValidator();
        
            if (validator.validatePassword(password)) {
                currentData.add(password);
            } else {
                throw new InvalidInputException("Invalid password format");
            }
        
            if (validator.validateEmail(email)) {
                currentData.add(email);
            } else {
                throw new InvalidInputException("Invalid Email format");
            }
        
            if (validator.validatePhone(phone)) {
                currentData.add(phone);
            } else {
                throw new InvalidInputException("Invalid Phone Number");
            }
        
            dataList.put(username, currentData);
        } else {
            throw new DuplicateUserException("User already exists");
        }
        

            
    
    

}
}
