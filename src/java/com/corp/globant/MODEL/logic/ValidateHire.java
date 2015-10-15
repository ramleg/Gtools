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
        
        //Validate Name
        if(v.forbiddenCaracters(hire.getName().toLowerCase(), "[^a-z ñ'áéíóú]"))
            throw new ValidateException("Forbidden Caracters");
        
        hire.setName(v.spaceCorrect(hire.getName()));
        
        
        return true;
    }
    
}
