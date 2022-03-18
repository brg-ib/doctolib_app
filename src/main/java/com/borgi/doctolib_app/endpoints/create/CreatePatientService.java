package com.borgi.doctolib_app.endpoints.create;

import com.borgi.doctolib_app.model.Patient;
import com.borgi.doctolib_app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientService {

    @Autowired
    PatientRepository repository;

    public Patient createNewPatient(Patient patient){
        return repository.save(patient);
    }
}
