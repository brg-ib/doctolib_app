package com.borgi.doctolib_app.repository;

import com.borgi.doctolib_app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    //Patient findPatientByNom(String nom) {};
}


