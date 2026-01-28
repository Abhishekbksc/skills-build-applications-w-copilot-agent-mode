package com.admission.student.service;

import com.admission.student.dto.StudentAdmissionRequest;
import com.admission.student.dto.StudentAdmissionResponse;
import com.admission.student.model.Student;
import com.admission.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdmissionService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentAdmissionResponse submitAdmission(StudentAdmissionRequest request) {
        // Check if student already exists
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Student with email " + request.getEmail() + " already exists");
        }

        // Validate class
        if (request.getAdmissionClass() != 10 && request.getAdmissionClass() != 12) {
            throw new IllegalArgumentException("Admission is only available for Class 10 and Class 12");
        }

        // Create new student
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setAdmissionClass(request.getAdmissionClass());
        student.setAdmissionStatus("ACCEPTED");

        // Save student
        Student savedStudent = studentRepository.save(student);

        // Create response with confirmation message
        String message = String.format(
            "Congratulations %s! Your admission has been accepted for Class %d. " +
            "We look forward to welcoming you to our institution.",
            savedStudent.getName(),
            savedStudent.getAdmissionClass()
        );

        return new StudentAdmissionResponse(
            savedStudent.getId(),
            savedStudent.getName(),
            savedStudent.getEmail(),
            savedStudent.getPhoneNumber(),
            savedStudent.getAdmissionClass(),
            savedStudent.getAdmissionStatus(),
            message,
            savedStudent.getCreatedAt()
        );
    }

    public List<StudentAdmissionResponse> getAllAdmissions() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    public StudentAdmissionResponse getAdmissionById(Long id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return mapToResponse(student);
    }

    private StudentAdmissionResponse mapToResponse(Student student) {
        String message = String.format(
            "Admission status for %s - Class %d: %s",
            student.getName(),
            student.getAdmissionClass(),
            student.getAdmissionStatus()
        );

        return new StudentAdmissionResponse(
            student.getId(),
            student.getName(),
            student.getEmail(),
            student.getPhoneNumber(),
            student.getAdmissionClass(),
            student.getAdmissionStatus(),
            message,
            student.getCreatedAt()
        );
    }
}
