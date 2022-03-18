package com.borgi.doctolib_app.endpoints.detail;


import com.borgi.doctolib_app.model.Patient;
import com.borgi.doctolib_app.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetailPatientService {

    @Autowired
    PatientRepository repository;

    public Patient listPatient(Integer id) {
       // return repository.findById(id).stream().filter(x -> x.getId()==(id)).collect(Collectors.toList()).get(0);
        return repository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
    }
}