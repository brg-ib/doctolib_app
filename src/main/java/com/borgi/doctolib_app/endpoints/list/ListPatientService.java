package com.borgi.doctolib_app.endpoints.list;

import com.borgi.doctolib_app.model.Patient;
import com.borgi.doctolib_app.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListPatientService {

    @Autowired
    PatientRepository repository;

    public List<Patient> listAllPatients() {
        return repository.findAll();
    }
/*    public Patient litPatientByName(String name) {
        return repository.findB.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    } */
}
