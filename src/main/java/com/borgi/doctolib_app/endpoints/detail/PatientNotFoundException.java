package com.borgi.doctolib_app.endpoints.detail;


import com.borgi.doctolib_app.model.Patient;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Integer id) {
        super("Could not find patient with id " + id + ".");
    }
}