package com.cns.demo.contorller;

import com.cns.demo.dto.PatientDto;
import com.cns.demo.pojo.Patient;
import com.cns.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/save")
    public ResponseEntity<Patient>createPatient(@ModelAttribute PatientDto patientDto) throws IOException {
        Patient patient1 = patientService.addPatient(patientDto);
        System.out.println(patient1);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }

}
