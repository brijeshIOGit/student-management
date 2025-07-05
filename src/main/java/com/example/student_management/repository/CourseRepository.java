package com.example.student_management.repository;

import com.example.student_management.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom query methods can be defined here if needed
}
