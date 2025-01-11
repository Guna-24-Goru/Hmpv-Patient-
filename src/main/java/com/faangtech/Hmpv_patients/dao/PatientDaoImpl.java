package com.faangtech.Hmpv_patients.dao;

import com.faangtech.Hmpv_patients.model.Patient;
import com.faangtech.Hmpv_patients.model.PatientStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("hmpvPatientDao")
public class PatientDaoImpl implements  PatientDao{

    private static  List<Patient> hmpvPatient= new ArrayList<>();

    @Override
    public int addPatient(UUID caseId, Patient patient) {
        hmpvPatient.add(new Patient(caseId,patient.getName(),patient.getGender(), PatientStatus.SUSPECT));
        return 1;
    }

    @Override
    public List<Patient> getAllPatients() {
        return hmpvPatient;
    }

    @Override
    public Optional<Patient> getPatientBYId(UUID caseId) {
        return hmpvPatient.stream().filter(patient -> patient.getCaseId()
                .equals(caseId)).findFirst();
    }

    @Override
    public List<Patient> getAllNegativeStatusPatients() {
        return hmpvPatient.stream().filter(patient -> patient.getPatientStatus()
                .equals(PatientStatus.NEGATIVE)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getAllPositiveStatusPatients() {
        return hmpvPatient.stream().filter(patient -> patient.getPatientStatus()
                .equals(PatientStatus.POSITIVE)).collect(Collectors.toList());
    }

    @Override
    public int removePatientById(UUID caseId) {
        Optional<Patient>patient=getPatientBYId(caseId);
        if(patient.isEmpty()){
            return 0;
        }
        hmpvPatient.remove(patient.get());
        return 1;
    }

    @Override
    public int removeAllNegativeStatusPatients() {
        List<Patient>negativeTestedPatients=getAllNegativeStatusPatients();
        if(negativeTestedPatients.isEmpty()){
            return 0;
        }
        hmpvPatient.removeAll(negativeTestedPatients);
        return 1;
    }

    @Override
    public int updatePatientDetailsById(UUID caseId, Patient newDetails) {
        return getPatientBYId(caseId).map(patient -> {
            int indexOfPatientToUpdate=hmpvPatient.indexOf(patient);
            if(indexOfPatientToUpdate>=0){
                hmpvPatient.set(indexOfPatientToUpdate,new Patient(caseId, newDetails.getName(),
                        newDetails.getGender(),newDetails.getPatientStatus()));
                return 1;
            }
            return 0;
        })
        .orElse(0);
    }
}
