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
    public Hire validate(Hire hire) throws ValidateException{
        
        //Validate Name
        if (hire.getName().isEmpty())
            throw new ValidateException("Wrong Data [Name]");
        if (!v.forbiddenCaracters(hire.getName().toLowerCase(), "[^a-z ñ'áéíóú]"))
            throw new ValidateException("Wrong Data [Name]");
        if(!v.maxLength(hire.getName(), 30))
            throw new ValidateException("Wrong Data [Name]");
        hire.setName(new WordUtils().capitalizeFully(v.spaceCorrect(hire.getName())));
        //Validate LastName
        if(hire.getLastname().isEmpty())
            throw new ValidateException("Wrong Data [LastName]");
        if (!v.forbiddenCaracters(hire.getLastname().toLowerCase(), "[^a-z ñ'áéíóú]"))
            throw new ValidateException("Wrong Data [LastName]");
        if(!v.maxLength(hire.getLastname(), 30))
            throw new ValidateException("Wrong Data [LastName]");
        hire.setLastname(new WordUtils().capitalizeFully(v.spaceCorrect(hire.getLastname())));
        //Validate ID Number
        if(hire.getIdNumber().isEmpty())
            throw new ValidateException("Wrong Data [ID Number]");
        if(!v.forbiddenCaracters(hire.getIdNumber(), "[^a-z0-9]"))
            throw new ValidateException("Wrong Data [ID Number]");
        if(!v.maxLength(hire.getIdNumber(), 30))
        hire.setIdNumber(hire.getIdNumber().toUpperCase(Locale.ENGLISH));
        //Validate DomainUser
        if(hire.getDomainUser().isEmpty())
            throw new ValidateException("Wrong Data [DomainUser]");
        if (!v.forbiddenCaracters(hire.getDomainUser().toLowerCase(), "[^a-z .]"))
            throw new ValidateException("Wrong Data [DomainUser]");
        if(!v.maxLength(hire.getDomainUser(), 21))
            throw new ValidateException("Wrong Data [DomainUser]");
        if(!v.dotCheck(hire.getDomainUser()))
            throw new ValidateException("Wrong Data [DomainUser]");
        
        
        System.out.println("Validation: OK");
        return hire;
    }
    
}
