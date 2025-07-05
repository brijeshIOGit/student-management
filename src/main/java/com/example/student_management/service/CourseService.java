package com.example.student_management.service;

import com.example.student_management.exception.CourseNotFound;
import com.example.student_management.model.Course;
import com.example.student_management.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFound("Course not found with id: " + id));
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourseById(id);

        course.setTitle(courseDetails.getTitle());
        course.setDescription(courseDetails.getDescription());
        return courseRepository.save(course);
    }

    public Course deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
        return course;
    }

}
