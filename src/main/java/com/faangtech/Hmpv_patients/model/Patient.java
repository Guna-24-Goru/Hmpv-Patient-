package com.faangtech.Hmpv_patients.model;

import org.springframework.lang.NonNull;


import java.util.UUID;

public class Patient {

    private final UUID caseId;
    @NonNull
    private final String name;
    private final Character gender;
    @NonNull
    private  final PatientStatus patientStatus;

    public Patient(UUID caseId,@NonNull String name, Character gender,@NonNull PatientStatus patientStatus) {
        this.caseId = caseId;
        this.name = name;
        this.gender = gender;
        this.patientStatus = patientStatus;
    }

    public UUID getCaseId() {
        return caseId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    @NonNull
    public PatientStatus getPatientStatus() {
        return patientStatus;
    }
}
