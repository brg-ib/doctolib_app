package com.borgi.doctolib_app.endpoints.update;

import com.borgi.doctolib_app.model.Patient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient/{id}")
@Tag(name = "Update an existing patient with the PUT method")
public class UpdatePatientController {

    @Autowired
    UpdatePatientService service;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Execute PUT method")
    public ResponseEntity<Patient> updatePatient_whenPutPatient(@RequestBody Patient patient, @PathVariable int id) {
        return ResponseEntity.ok().body(service.updatePatient(id, patient));
    }
}