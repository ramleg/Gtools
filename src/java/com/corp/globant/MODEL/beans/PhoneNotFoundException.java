package com.corp.globant.MODEL.beans;
/**
 *
 * @author Ramiro Acoglanis
 */
public class PhoneNotFoundException extends Exception{
    public PhoneNotFoundException() {}
    public PhoneNotFoundException(String message) {
        super(message);
    }
}