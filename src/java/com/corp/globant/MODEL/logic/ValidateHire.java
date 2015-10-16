package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.Hire;
import com.corp.globant.MODEL.beans.ValidateException;
import java.util.Locale;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author ramiro.acoglanis
 */
public class ValidateHire {
    Validator v = new Validator();
    public boolean validate(Hire hire) throws ValidateException{
        
        //Validate Name
        if(v.forbiddenCaracters(hire.getName().toLowerCase(), "[^a-z ñ'áéíóú]") && v.maxLength(hire.getName(), 50))
            throw new ValidateException("Wrong Data [Name]");
        hire.setName(new WordUtils().capitalizeFully(v.spaceCorrect(hire.getName())));
        //Validate LastName
        if(v.forbiddenCaracters(hire.getLastname().toLowerCase(), "[^a-z ñ'áéíóú]") && v.maxLength(hire.getLastname(), 50))
            throw new ValidateException("Wrong Data [LastName]");
        hire.setName(new WordUtils().capitalizeFully(v.spaceCorrect(hire.getLastname())));
        //Validate ID Number
        if(v.forbiddenCaracters(hire.getIdNumber(), "[^a-z0-9]") && v.maxLength(hire.getIdNumber(), 20))
            throw new ValidateException("Wrong Data [ID Number]");
        hire.setIdNumber(hire.getIdNumber().toUpperCase(Locale.ENGLISH));
        
        
        
        return true;
    }
    
}
