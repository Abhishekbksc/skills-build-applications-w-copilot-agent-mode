package com.admission.student.controller;

import com.admission.student.dto.StudentAdmissionRequest;
import com.admission.student.dto.StudentAdmissionResponse;
import com.admission.student.service.AdmissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @PostMapping
    public ResponseEntity<StudentAdmissionResponse> submitAdmission(
            @Valid @RequestBody StudentAdmissionRequest request) {
        try {
            StudentAdmissionResponse response = admissionService.submitAdmission(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error processing admission: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<StudentAdmissionResponse>> getAllAdmissions() {
        List<StudentAdmissionResponse> admissions = admissionService.getAllAdmissions();
        return ResponseEntity.ok(admissions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentAdmissionResponse> getAdmissionById(@PathVariable Long id) {
        try {
            StudentAdmissionResponse response = admissionService.getAdmissionById(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Student Admission Service is running!");
    }
}
