package com.admission.student.dto;

import jakarta.validation.constraints.*;

public class StudentAdmissionRequest {

    @NotBlank(message = "Student name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
    private String phoneNumber;

    @NotNull(message = "Class is required")
    @Min(value = 10, message = "Class must be 10 or 12")
    @Max(value = 12, message = "Class must be 10 or 12")
    private Integer admissionClass;

    // Constructors
    public StudentAdmissionRequest() {
    }

    public StudentAdmissionRequest(String name, String email, String phoneNumber, Integer admissionClass) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.admissionClass = admissionClass;
    }

    // Getters and Setters
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
}
