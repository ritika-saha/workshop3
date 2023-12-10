package com.store;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    
    boolean validatePassword(String data){
         final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
         Matcher matcher = pattern.matcher(data.trim());
        boolean result=matcher.matches();
        return result;
    }

    boolean validateEmail(String data){
        final String emailRegex = "^[a-zA-Z0-9.$&%_+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+$";
        Pattern pattern = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
         Matcher matcher = pattern.matcher(data);
        boolean result=matcher.matches();
        return result;
    }

    boolean validatePhone(String data){
        final String phoneRegex="^91 [1-9]\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
         Matcher matcher = pattern.matcher(data);
        boolean result=matcher.matches();
        return result;
    }

    boolean validateISBN(String data){
        final String isbnRegex="^(?:978|979)-\\d{1,5}-\\d{1,7}-\\d{1,6}-\\d$";
        Pattern pattern = Pattern.compile(isbnRegex);
         Matcher matcher = pattern.matcher(data);
        boolean result=matcher.matches();
        return result;
    }
    
    boolean validateBookEntry(String data){
        if(data==null)
        return false;

        return true;
    }
}
