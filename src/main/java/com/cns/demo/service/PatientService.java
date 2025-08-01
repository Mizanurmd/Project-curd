package com.cns.demo.service;

import com.cns.demo.dto.PatientDto;
import com.cns.demo.pojo.Patient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PatientService {
  Patient addPatient(PatientDto patientDto) throws IOException;
    Patient updatePatient(Long id, Patient patient, MultipartFile image);
    Patient getPatient(Long id);
    List<Patient> getAllPatients();
    void deletePatient(Long id);
}
