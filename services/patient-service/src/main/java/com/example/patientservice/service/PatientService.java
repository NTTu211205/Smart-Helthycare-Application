package com.example.patientservice.service;


import com.example.patientservice.model.Patient;
import com.example.patientservice.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Optional<Patient> findByPatientId(Integer patientId){
        return patientRepo.findByPatientId(patientId);
    }
    public Optional<Patient> findByUserId(Integer userId){
        return patientRepo.findByUserId(userId);
    }
    public Optional<List<Patient>> findByFullName(String fullName){
        return patientRepo.findByFullName(fullName);
    }

}
