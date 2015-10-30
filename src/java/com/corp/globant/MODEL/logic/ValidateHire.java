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
        if(!this.validateName(hire))
            throw new ValidateException("name");
        //Validate LastName
        if(!this.validateLastName(hire))
            throw new ValidateException("lastname");
        //Validate ID Number
        if(!this.validateIdNumber(hire))
            throw new ValidateException("idnumber");
        //Validate DomainUser
        if(!this.validateDomainUser(hire))
            throw new ValidateException("user");
        
        //Validate SubDomain
        
        
        return hire;
    }
    
    public boolean validateName(Hire hire){
        
        if (hire.getName().isEmpty())
            return false;
        if (!v.forbiddenCaracters(hire.getName().toLowerCase(), "[^a-z ñ'áéíóú]"))
            return false;
        if(!v.maxLength(hire.getName(), 30))
            return false;
        
        hire.setName(WordUtils.capitalizeFully(v.spaceCorrect(hire.getName())));
        
        return true;
    }
    public boolean validateLastName(Hire hire){
        if(hire.getLastname().isEmpty())
            return false;
        if (!v.forbiddenCaracters(hire.getLastname().toLowerCase(), "[^a-z ñ'áéíóú]"))
            return false;
        if(!v.maxLength(hire.getLastname(), 30))
            return false;
        
        hire.setLastname(WordUtils.capitalizeFully(v.spaceCorrect(hire.getLastname())));
        
        return true;
    }
    public boolean validateIdNumber(Hire hire){
        if(hire.getIdNumber().isEmpty())
            return false;
        if(!v.forbiddenCaracters(hire.getIdNumber(), "[^a-z0-9]"))
            return false;
        if(!v.maxLength(hire.getIdNumber(), 30))
            return false;
            
        hire.setIdNumber(hire.getIdNumber().toUpperCase(Locale.ENGLISH));
        
        return true;
    }
    public boolean validateDomainUser(Hire hire){
        if(hire.getDomainUser().isEmpty())
            return false;
        if (!v.forbiddenCaracters(hire.getDomainUser().toLowerCase(), "[^a-z .]"))
            return false;
        if(!v.maxLength(hire.getDomainUser(), 21))
            return false;
        if(!v.dotCheck(hire.getDomainUser()))
            return false;
        
        return true;
    }
}
