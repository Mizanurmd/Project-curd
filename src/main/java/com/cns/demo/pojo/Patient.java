package com.cns.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String patientName;
    private String gender;
    private int age;
    private Date dateOfBirth;
    private String address;
    private String phone;
    private String email;
    @Lob
    private byte[] photo;
    private String imageType;
    private String imageName;
    private Long imageSize;

    @Lob
    private byte[] file;
    private String fileName;
    private String fileType;
    private Long fileSize;

    private boolean activeYn;


}
