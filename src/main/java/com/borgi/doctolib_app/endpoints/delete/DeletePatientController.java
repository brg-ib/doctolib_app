package com.borgi.doctolib_app.endpoints.delete;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient/{id}")
@Tag(name = "Delete an existing patient with the DELETE method")
public class DeletePatientController {

    @Autowired
    DeletePatientService service;

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Execute DELETE method")
    public void deletePatient_whenDeletePatient(@PathVariable int id) {
        service.deletePatient(id);
    }
}