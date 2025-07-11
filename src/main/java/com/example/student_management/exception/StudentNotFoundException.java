package com.example.student_management.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student not found with id: " + id);
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
