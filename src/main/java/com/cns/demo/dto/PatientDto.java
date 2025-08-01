package com.cns.demo.dto;

import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


@Data
public class PatientDto {
    private String patientName;
    private String gender;
    private int age;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String email;

    private MultipartFile photo;
}
