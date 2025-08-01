package com.cns.demo.serviceImp;

import com.cns.demo.dto.PatientDto;
import com.cns.demo.pojo.Patient;
import com.cns.demo.repository.PatientRepository;
import com.cns.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public Patient addPatient(PatientDto patientDto) throws IOException {
        Patient patient = new Patient();
        patient.setPatientName(patientDto.getPatientName());
        patient.setGender(patientDto.getGender());
        patient.setAge(patientDto.getAge());
        if (patientDto.getDateOfBirth() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                patient.setDateOfBirth(LocalDate.parse(sdf.format(patientDto.getDateOfBirth())));
            } catch (Exception e) {
                throw new RuntimeException("Invalid date format. Expected yyyy-MM-dd");
            }
        }
        patient.setAddress(patientDto.getAddress());
        patient.setPhone(patientDto.getPhone());
        patient.setEmail(patientDto.getEmail());
        if (patientDto.getPhoto() != null && !patientDto.getPhoto().isEmpty()) {
            patient.setPhoto(patientDto.getPhoto().getBytes());
        }
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient, MultipartFile image) {
        return null;
    }

    @Override
    public Patient getPatient(Long id) {
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        return List.of();
    }

    @Override
    public void deletePatient(Long id) {

    }
}
