package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.Hire;

/**
 *
 * @author ramiro.acoglanis
 */
public class ValidateHire {
    Validator v = new Validator();
    public boolean validate(Hire hire){
        
        return v.forbiddenCaracters(hire.getName(), "[^a-z ñ'áéíóú]");
    }
    
}
