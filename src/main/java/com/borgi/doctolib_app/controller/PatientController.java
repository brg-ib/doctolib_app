package com.borgi.doctolib_app.controller;

import com.borgi.doctolib_app.model.Patient;

import com.borgi.doctolib_app.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PatientController {

    @Autowired
    PatientRepository patientRepo;

        List<Patient> patients = new ArrayList<>();
        {
            patients.add(new Patient("Borgi", "Ihcen", "Tunis","1930516773453"));
            patients.add(new Patient("Azize", "Younes", "Rabat","196051670000"));
            patients.add(new Patient("Mendaci", "Zahir", "Alger","1990389342123"));
            patients.add(new Patient("Diop", "Awa", "Dakar","2970516630055"));

        }


        @RequestMapping(value = "/getAllPatients", method = RequestMethod.GET, produces = "application/json")
        public List<Patient> getAllPatients() {
            return patients;
        }


        public void savePatient(Patient patient){
            patientRepo.save(patient);
        }
        public Optional<Patient> getPatient(Integer id){
            return patientRepo.findById(id);
        }
        public void deletePatient(Integer id){
            patientRepo.deleteById(id);
        }

        @RequestMapping(value = "/getPatient/{nom}", method = RequestMethod.GET, produces = "application/json")
        public Patient getPatientByName(@PathVariable(value = "nom") String name) {
            return patients.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
        }

        @RequestMapping(value = "/getPatient/{ville}", method = RequestMethod.GET, produces = "application/json")
        public List<Patient> getPatientByVille(@PathVariable(value = "ville") String ville) {
            System.out.println("Searching Patient in country : " + ville);
            List<Patient> patientsByVille = patients.stream().filter(x -> x.getVille().equalsIgnoreCase(ville))
                    .collect(Collectors.toList());
            System.out.println(patientsByVille);
            return patientsByVille;
        }

        @RequestMapping(value = "/getPatient/{ss}", method = RequestMethod.GET, produces = "application/json")
        public List<Patient> getPatientBySs(@PathVariable(value = "ss") String ss) {
            return patients.stream().filter(x -> x.getSs().equals(ss)).collect(Collectors.toList());
        }

        @PostMapping(value ="/patients")
        public Patient createPatient(@Valid @RequestBody Patient patient) {
            return patientRepo.save(patient);
        }

    @PutMapping("/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") int id,
                                                  @Valid @RequestBody Patient patientDetails) throws InvalidConfigurationPropertyValueException {
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("Patient",patientRepo,"Patient not found for this id :: " + id));
        patient.setNom(patientDetails.getNom());
        patient.setPrenom(patientDetails.getPrenom());
        patient.setVille(patientDetails.getVille());
        patient.setSs(patientDetails.getSs());
        final Patient updatedPatient = patientRepo.save(patient);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") int id) {
        try {
            patientRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
