package com.borgi.doctolib_app.endpoints.update;

import com.borgi.doctolib_app.endpoints.detail.PatientNotFoundException;
import com.borgi.doctolib_app.model.Patient;
import com.borgi.doctolib_app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePatientService {

    @Autowired
    PatientRepository repository;

    public Patient updatePatient(Integer id, Patient patient) {
        repository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
        patient.setId(id);
        return repository.save(patient);
    }
}