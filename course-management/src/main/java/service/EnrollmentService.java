package com.example.coursemanagement.service;

import com.example.coursemanagement.model.Course;
import com.example.coursemanagement.model.Enrollment;
import com.example.coursemanagement.model.Student;
import com.example.coursemanagement.repository.CourseRepository;
import com.example.coursemanagement.repository.EnrollmentRepository;
import com.example.coursemanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment createEnrollment(Long studentId, Long courseId) {
        // Fetch student and course from the database
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student != null && course != null) {
            // Check if the student is already enrolled in the course
            List<Enrollment> existingEnrollments = enrollmentRepository.findAllByStudentId(studentId);
            boolean alreadyEnrolled = existingEnrollments.stream()
                    .anyMatch(enrollment -> enrollment.getCourse().getId().equals(courseId));

            if (alreadyEnrolled) {
                throw new IllegalArgumentException("Student is already enrolled in this course.");
            }

            // Proceed with enrollment
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            return enrollmentRepository.save(enrollment);
        }

        throw new IllegalArgumentException("Invalid student ID or course ID.");
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findAllByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findAllByCourseId(courseId);
    }
}
