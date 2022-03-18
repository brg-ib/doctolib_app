package com.borgi.doctolib_app.endpoints.create;

import com.borgi.doctolib_app.model.Patient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/patient")
@Tag(name = "Create a new patient with the POST method")
public class CreatePatientController {

    @Autowired
    CreatePatientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   @Operation(summary = "Execute POST method")
    public ResponseEntity<Patient> createNewPatient_whenPostPatient(@RequestBody Patient patient) {

        Patient createdUser = service.createNewPatient(patient);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(uri).body(createdUser);
    }
}