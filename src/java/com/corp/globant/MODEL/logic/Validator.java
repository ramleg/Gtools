package com.corp.globant.MODEL.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

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
    public boolean forbiddenCaracters(String str, String regex){
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        return m.find();
    }
    
    public boolean dotCheck (String str){
        
        String[] parts = str.split(Pattern.quote(""));
        if(parts[0].equals("."))
            return false;
        if(parts[parts.length-1].equals("."))
            return false;
        parts = str.split(Pattern.quote("."));
        if(parts.length != 2)
            return false;        
        return true;
    }
    
    public void dotCorrect (String str){
        
    }
    
    public String spaceCorrect (String str){
        String[] parts = str.split(Pattern.quote("."));
        String response = "";
        for(String s : parts)
            System.out.println(s + "/");
            //response = response + s + " ";
        return response.trim();
    }
    
}
