package com.faangtech.Hmpv_patients.controller;

import com.faangtech.Hmpv_patients.model.Patient;
import com.faangtech.Hmpv_patients.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/hmpv/patient")
@RestController
public class PatientController {
    private  final PatientService service;
@Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }
    @PostMapping
    public void addPatient(@RequestBody Patient patient){
    service.addPatient(patient);
    }
    @GetMapping("/all")
    public List<Patient> getPatientId(){
    return  service.getAllPatient();
    }
    @GetMapping("/getById")
    public Patient getPatientById(@RequestParam("caseId")UUID caseId){
    return service.getPatientById(caseId).orElse(null);
    }
    @GetMapping("/negative")
    public List<Patient> getAllNegativeStatusPatients(){
    return service.getAllNegitiveStatusPatient();
    }
    @GetMapping("/positive")
    public List<Patient> getAllPositiveStatusPatients(){
        return service.getAllPositiveStatusPatient();
    }
    @PutMapping("/update")
    public void updateDetailsById(@RequestParam("caseId")UUID caseId,@RequestBody Patient newDetails){
    service.updatePatientById(caseId,newDetails);
    }

    @DeleteMapping("/deleteById")
    public  void removePatientById(@RequestParam("caseId") UUID caseId) {
        service.removePatientById(caseId);
    }
    @DeleteMapping("/deleteNegative")
    public void removeAllNegativeStatusPatients(){
    service.removeAllNegativeStatusPatients();
    }

}
