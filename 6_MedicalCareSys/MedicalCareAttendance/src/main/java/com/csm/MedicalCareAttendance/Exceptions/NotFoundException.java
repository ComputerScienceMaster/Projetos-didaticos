package com.csm.MedicalCareSys.Exceptions;

public class NotFoundException extends RuntimeException  {
    public NotFoundException(String message) {
        super(message);
    }
}
