package com.borgi.doctolib_app.endpoints.delete;

import com.borgi.doctolib_app.repository.PatientRepository;
import com.borgi.doctolib_app.endpoints.detail.PatientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePatientService {

    @Autowired
    PatientRepository repository;

    public void deletePatient(Integer id) {

        repository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        repository.deleteById(id);
    }
}