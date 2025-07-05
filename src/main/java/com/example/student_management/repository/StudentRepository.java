package com.example.student_management.repository;

import com.example.student_management.model.Course;
import com.example.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom query methods can be defined here if needed
    List<Student> findByCourse(Course course);
}
