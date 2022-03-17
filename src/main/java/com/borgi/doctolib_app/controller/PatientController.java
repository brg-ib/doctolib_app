package com.borgi.doctolib_app.controller;

import com.borgi.doctolib_app.model.Patient;
import com.borgi.doctolib_app.repository.PatientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.context.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PatientController {

    @Autowired
    PatientRepository patientRepo;

        List<Patient> patients = new ArrayList<Patient>();
        {
            patients.add(new Patient("Borgi", "Ihcen", "Tunis","1930516773453"));
            patients.add(new Patient("Azize", "Younes", "Rabat","196051670000"));
            patients.add(new Patient("Mendaci", "Zahir", "Alger","1990389342123"));
            patients.add(new Patient("Diop", "Awa", "Dakar","2970516630055"));

        }

        @ApiOperation(value = "Get list of Patients in the System ", response = Iterable.class, tags = "getAllPatients")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Suceess | OK"),
                @ApiResponse(code = 401, message = "not authorized!"),
                @ApiResponse(code = 403, message = "forbidden !!!"),
                @ApiResponse(code = 404, message = "not found !!!") })

       // @ApiOperation(value = "Get all Patients in the System ", response = Patient.class, tags = "getAllPatients")
        @RequestMapping(value = "/getAllPatients")
        public List<Patient> getAllPatients() {
            return patients;
        }

        @ApiOperation(value = "Get specific Patient by Name in the System ", response = Patient.class, tags = "getPatientByName")
        @RequestMapping(value = "/getPatientByName/{nom}")
        public Patient getPatientByName(@PathVariable(value = "nom") String name) {
            return patients.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
        }

        @ApiOperation(value = "Get specific Patient By Ville in the System ", response = Patient.class, tags = "getPatientByVille")
        @RequestMapping(value = "/getPatientByVille/{ville}")
        public List<Patient> getPatientByVille(@PathVariable(value = "ville") String ville) {
            System.out.println("Searching Patient in country : " + ville);
            List<Patient> patientsByVille = patients.stream().filter(x -> x.getVille().equalsIgnoreCase(ville))
                    .collect(Collectors.toList());
            System.out.println(patientsByVille);
            return patientsByVille;
        }

        @ApiOperation(value = "Get specific Patient By Securite Social in the System ",response = Patient.class,tags="getPatientBySs")
        @RequestMapping(value = "/getPatientBySs/{ss}")
        public List<Patient> getPatientBySs(@PathVariable(value = "ss") String ss) {
            return patients.stream().filter(x -> x.getSs().equals(ss)).collect(Collectors.toList());
        }

        @ApiOperation(value = "Create specific Patient in the System ",response = Patient.class,tags="createPatient")
        @PostMapping(value ="/patients")
        public Patient createPatient(@Valid @RequestBody Patient patient) {
            return patientRepo.save(patient);
        }

    @ApiOperation(value = "PUT specific Patient in the System ",response = Patient.class,tags="updatePatient")
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

    @ApiOperation(value = "Delete specific Patient in the System ",response = Patient.class,tags="deletePatient")
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
