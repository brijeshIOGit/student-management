package com.example.student_management.service;

import com.example.student_management.exception.CourseNotFound;
import com.example.student_management.exception.StudentNotFoundException;
import com.example.student_management.model.Course;
import com.example.student_management.model.Student;
import com.example.student_management.repository.CourseRepository;
import com.example.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private  final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        if(student.getCourse() != null && student.getCourse().getId() != null){
            Course existingCourse  = courseRepository.findById(student.getCourse().getId()).orElseThrow(()-> new CourseNotFound("Course not found with id: " + student.getCourse().getId()));
            student.setCourse(existingCourse);
        }

        return studentRepository.save(student);
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setPhone(studentDetails.getPhone());
        student.setAddress(studentDetails.getAddress());
        student.setAge(studentDetails.getAge());

        if(student.getCourse() != null && student.getCourse().getId() != null){
            Course existingCourse  = courseRepository.findById(student.getCourse().getId()).orElseThrow(()-> new CourseNotFound("Course not found with id: " + student.getCourse().getId()));
            student.setCourse(existingCourse);
        }else{
            student.setCourse(null);
        }

        return studentRepository.save(student);
    }

    public Student deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
        return student;
    }

    public List<Student> getStudentsByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFound("Course not found with id: " + courseId));
        return studentRepository.findByCourse(course);
    }

}
