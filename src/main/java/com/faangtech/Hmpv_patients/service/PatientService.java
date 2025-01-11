package com.faangtech.Hmpv_patients.service;

import com.faangtech.Hmpv_patients.dao.PatientDao;
import com.faangtech.Hmpv_patients.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientDao dao;
    @Autowired
    public PatientService(@Qualifier("hmpvPatientDao") PatientDao dao) {
        this.dao = dao;
    }
    public int addPatient(Patient patient){
        return dao.addPatient(patient);
    }
    public List<Patient>getAllPatient(){
        return dao.getAllPatients();
    }
    public Optional<Patient>getPatientById(UUID caseId){
        return dao.getPatientBYId(caseId);
    }
    public List<Patient>getAllNegitiveStatusPatient(){
        return dao.getAllNegativeStatusPatients();
    }
    public List<Patient>getAllPositiveStatusPatient(){
        return dao.getAllPositiveStatusPatients();
    }
    public int removePatientById(UUID caseId){
        return  dao.removePatientById(caseId);
    }
    public  int removeAllNegativeStatusPatients(){
        return dao.removeAllNegativeStatusPatients();
    }
    public  int updatePatientById(UUID caseId,Patient newDetails){
        return  dao.updatePatientDetailsById(caseId, newDetails);
    }

}
