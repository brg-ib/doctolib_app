package com.borgi.doctolib_app.controller;

import com.borgi.doctolib_app.model.Patient;
import com.borgi.doctolib_app.repository.PatientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "PatientController", description = "REST Apis related to Patient Entity !")
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
        public List<Patient> getPatientBySs(@PathVariable(value = "securiteSocial") String ss) {
            return patients.stream().filter(x -> x.getSs().equals(ss)).collect(Collectors.toList());
        }

        @ApiOperation(value = "Create specific Patient in the System ",response = Patient.class,tags="createPatient")
        @PostMapping(value ="/patients")
        public Patient createPatient(@Valid @RequestBody Patient patient) {
            return patientRepo.save(patient);
        }

}
