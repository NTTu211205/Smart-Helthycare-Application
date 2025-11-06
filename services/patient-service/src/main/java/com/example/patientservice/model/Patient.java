package com.example.patientservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer patientId;

    private String fullName;

    private Integer userId;

    private Date birth, registeredAt;

    private Gender gender;

    private String insuranceId, emergencyCallingNumber, job;

    private BloodType bloodType;

    private double heights, weights;

    private Boolean isActive;
}

enum BloodType{
    A,
    B,
    AB,
    O
}

enum Gender{
    MALE,
    FEMALE,
}

