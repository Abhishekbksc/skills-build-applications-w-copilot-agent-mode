package com.admission.student.dto;

import java.time.LocalDateTime;

public class StudentAdmissionResponse {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Integer admissionClass;
    private String admissionStatus;
    private String message;
    private LocalDateTime createdAt;

    // Constructors
    public StudentAdmissionResponse() {
    }

    public StudentAdmissionResponse(Long id, String name, String email, String phoneNumber, 
                                    Integer admissionClass, String admissionStatus, String message, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.admissionClass = admissionClass;
        this.admissionStatus = admissionStatus;
        this.message = message;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAdmissionClass() {
        return admissionClass;
    }

    public void setAdmissionClass(Integer admissionClass) {
        this.admissionClass = admissionClass;
    }

    public String getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(String admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
