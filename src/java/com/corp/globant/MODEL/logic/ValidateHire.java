package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.Hire;
import com.corp.globant.MODEL.beans.ValidateException;

/**
 *
 * @author ramiro.acoglanis
 */
public class ValidateHire {
    Validator v = new Validator();
    public boolean validate(Hire hire) throws ValidateException{
        
        return v.forbiddenCaracters(hire.getName(), "[^a-z ñ'áéíóú]");
    }
    
}
