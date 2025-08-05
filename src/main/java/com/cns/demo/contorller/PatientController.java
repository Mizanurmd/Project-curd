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
import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Save data into DB
    @PostMapping("/save")
    public ResponseEntity<Patient> createPatient(@ModelAttribute PatientDto patientDto) throws IOException {
        Patient patient1 = patientService.addPatient(patientDto);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }

    // For update patient into DB
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@ModelAttribute PatientDto patientDto, @PathVariable("id") long id) throws IOException {
        Patient patient1 = patientService.updatePatient(patientDto, id);
        return new ResponseEntity<>(patient1, HttpStatus.OK);
    }

    // Single data retrieve from DB
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id) throws IOException {
        Patient patient = patientService.getPatient(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    // Retrieve all data from DB
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // delete single data from DB
    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable("id") long id) throws IOException {
        patientService.deletePatient(id);
    }

}
