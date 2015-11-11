package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.Errors;
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
    Errors e = new Errors();
    
    public Hire fix(Hire hire){
        
        hire.setName(WordUtils.capitalizeFully(v.spaceCorrect(hire.getName())));
        hire.setLastname(WordUtils.capitalizeFully(v.spaceCorrect(hire.getLastname())));
        hire.setIdNumber(hire.getIdNumber().toUpperCase(Locale.ENGLISH));
        hire.setDomainUser(hire.getDomainUser().toLowerCase().trim());
        System.out.println("3");
        return hire;
    }
    
    
    public Errors validate(Hire hire){
        //Validate Name
        if(!this.validateName(hire))
            e.addError("Name");
        //Validate LastName
        if(!this.validateLastName(hire))
            e.addError("Last Name");
        //Validate ID Number
        if(!this.validateIdNumber(hire))
            e.addError("ID Number");
        //Validate DomainUser
        if(!this.validateDomainUser(hire))
            e.addError("User");
        //Validate SubDomain
        
        return e;
    }
    
    public boolean validateName(Hire hire){
        
        if (hire.getName().isEmpty())
            return false;
        if (!v.forbiddenCaracters(hire.getName().toLowerCase(), "[^a-z ñ'áéíóú]"))
            return false;
        if(!v.maxLength(hire.getName(), 30))
            return false;
        return true;
    }
    public boolean validateLastName(Hire hire){
        if(hire.getLastname().isEmpty())
            return false;
        if (!v.forbiddenCaracters(hire.getLastname().toLowerCase(), "[^a-z ñ'áéíóú]"))
            return false;
        if(!v.maxLength(hire.getLastname(), 30))
            return false;
        return true;
    }
    public boolean validateIdNumber(Hire hire){
        if(hire.getIdNumber().isEmpty())
            return false;
        if(!v.forbiddenCaracters(hire.getIdNumber(), "[^A-Z0-9]"))
            return false;
        if(!v.maxLength(hire.getIdNumber(), 30))
            return false;
        return true;
    }
    public boolean validateDomainUser(Hire hire){
        if(hire.getDomainUser().isEmpty())
            return false;
        if(!v.forbiddenCaracters(hire.getDomainUser(), "[^a-z .]"))
            return false;
        if(!v.maxLength(hire.getDomainUser(), 21))
            return false;
        if(!v.dotCheck(hire.getDomainUser()))
            return false;
        if(v.existInDB(hire.getDomainUser()))
            return false;
        if(v.existInAD(hire.getDomainUser()))
            return false;
        
        return true;
    }
    
}
