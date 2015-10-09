package com.corp.globant.MODEL.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ramiro.acoglanis
 */
public class Validator {
    
    public boolean maxLength (String str, int max){
        if(str.length() > max){
            return false;
        }
        return true;
    }
    public boolean standarCaracters(String str){
        
        Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        return m.find();
    }
    
    
}
