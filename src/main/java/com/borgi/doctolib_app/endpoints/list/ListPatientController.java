package com.borgi.doctolib_app.endpoints.list;



import com.borgi.doctolib_app.model.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
@Tag(name = "List all existing patients with the GET method")
public class ListPatientController {
    @Autowired
    ListPatientService service;

    List<Patient> patients = new ArrayList<>();
    {
        patients.add(new Patient("Borgi", "Ihcen", "Tunis","1930516773453"));
        patients.add(new Patient("Azize", "Younes", "Rabat","196051670000"));
        patients.add(new Patient("Mendaci", "Zahir", "Alger","1990389342123"));
        patients.add(new Patient("Diop", "Awa", "Dakar","2970516630055"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Execute GET method")
    public ResponseEntity<List<Patient>> listAllPatients_whenGetPatients() {
        return ResponseEntity.ok().body(service.listAllPatients());
    }
}