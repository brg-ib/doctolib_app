package com.borgi.doctolib_app.endpoints.list;

import com.borgi.doctolib_app.model.Patient;
import com.borgi.doctolib_app.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPatientService {

    @Autowired
    PatientRepository repository;

    public List<Patient> listAllPatients() {
        return repository.findAll();
    }
}
