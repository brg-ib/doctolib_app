package com.borgi.doctolib_app.endpoints.detail;


import com.borgi.doctolib_app.model.Patient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient/{id}")
@Tag(name = "List an existing patient with the GET method")
public class DetailPatientController {

    @Autowired
    DetailPatientService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Execute GET method")
    public ResponseEntity<Patient> list(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.listPatient(id));
    }


}
