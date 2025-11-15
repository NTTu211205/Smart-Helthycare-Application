package com.example.patientservice.controller;

import com.example.patientservice.model.Patient;
import com.example.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("/profile/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer patientId){
        return patientService.findByPatientId(patientId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
