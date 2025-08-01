package com.cns.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patient")
public class Patient extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String patientName;
    private String gender;
    private int age;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String email;
    @Lob
    private byte[] photo;


}
