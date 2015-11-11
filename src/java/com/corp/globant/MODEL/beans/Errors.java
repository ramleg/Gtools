package com.corp.globant.MODEL.beans;
import java.util.ArrayList;

/**
 *
 * @author ramiro.acoglanis
 */
public class Errors {
    
    private ArrayList<String> errors = new ArrayList<>();

    public ArrayList getErrors() {
        return this.errors;
    }

    public void setErrors(ArrayList errors) {
        this.errors = errors;
    }
    
    public void addError(String error){
        errors.add(error);
    }
}
