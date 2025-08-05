package com.cns.demo.dto;

import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;


@Data
public class PatientDto {
    private String patientName;
    private String gender;
    private int age;
    private Date dateOfBirth;
    private String address;
    private String phone;
    private String email;

    // for photo
    private MultipartFile photo;
    private String imageType;
    private String imageName;
    private Long imageSize;

    //For file
    private MultipartFile file;
    private String fileName;
    private String fileType;
    private Long fileSize;

    private boolean activeYn;
}
