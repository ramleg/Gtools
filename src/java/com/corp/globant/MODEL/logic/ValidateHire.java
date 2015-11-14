package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.*;
import com.corp.globant.MODEL.dao.ConnectionManager;
import com.corp.globant.MODEL.dao.CountryDAOpsql;
import com.corp.globant.MODEL.dao.EmailDomainDAOpsql;
import com.corp.globant.MODEL.dao.EmailGroupDAOpsql;
import com.corp.globant.MODEL.dao.LocationDAOpsql;
import com.corp.globant.MODEL.dao.PositionDAOpsql;
import com.corp.globant.MODEL.dao.SubDomainDAOpsql;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        if(!this.validateSubDomain(hire))
            e.addError("Sub Domain");
        //Validate Email Domain
        if(!this.validateEmailDomain(hire))
            e.addError("Email Domain");
        //Validate Country
        if(!this.validateCountry(hire))
            e.addError("Country");
        if(!this.validatePosition(hire))
            e.addError("Position");
        if(!this.validateLocation(hire))
            e.addError("Location");
        if(!this.validateEmailGroup(hire))
            e.addError("Email Groups");
        
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
    
    private boolean validateSubDomain(Hire hire){
        
        try {
            if (hire.getSubDomain().getId().isEmpty())
                return false;
            SubDomain x = SubDomainDAOpsql.getById(ConnectionManager.getConnection(), hire.getSubDomain().getId());
            if(x.getId().isEmpty())
                return false;
        } catch (Exception ex) {
            Logger.getLogger(ValidateHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    private boolean validateEmailDomain(Hire hire){
        
        try {
            if (hire.getEmailDomian().getId().isEmpty())
                return false;
            EmailDomain x = EmailDomainDAOpsql.getById(ConnectionManager.getConnection(), hire.getEmailDomian().getId());
            if(x.getId().isEmpty())
                return false;
        } catch (Exception ex) {
            Logger.getLogger(ValidateHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    private boolean validateCountry(Hire hire){
        
        try {
            if (hire.getCountry().getId().isEmpty())
                return false;
            if(CountryDAOpsql.getById(ConnectionManager.getConnection(), hire.getCountry().getId()).getId().isEmpty())
                return false;
        } catch (Exception ex) {
            Logger.getLogger(ValidateHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    private boolean validatePosition(Hire hire){
        
        try {
            if (hire.getPosition().getId().isEmpty())
                return false;
            if(PositionDAOpsql.getById(ConnectionManager.getConnection(), hire.getPosition().getId()).getId().isEmpty())
                return false;
        } catch (Exception ex) {
            Logger.getLogger(ValidateHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    private boolean validateLocation(Hire hire){
        
        try {
            if (hire.getLocation().getId().isEmpty())
                return false;
            if(LocationDAOpsql.getById(ConnectionManager.getConnection(), hire.getLocation().getId()).getId().isEmpty())
                return false;
        } catch (Exception ex) {
            Logger.getLogger(ValidateHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    private boolean validateEmailGroup(Hire hire){
        
        try {
            if (hire.getEmailGroup().getId().isEmpty())
                return false;
            if(EmailGroupDAOpsql.getById(ConnectionManager.getConnection(), hire.getEmailGroup().getId()).getId().isEmpty())
                return false;
        } catch (Exception ex) {
            Logger.getLogger(ValidateHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}
