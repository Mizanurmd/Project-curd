package com.cns.demo.service;

import com.cns.demo.dto.PatientDto;
import com.cns.demo.pojo.Patient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PatientService {
    Patient addPatient(PatientDto patientDto) throws IOException;

    Patient getPatient(Long id);

    Patient updatePatient(PatientDto patientDto, long id) throws IOException;

    List<Patient> getAllPatients();

    void deletePatient(Long id);
}
