package com.example.coursemanagement.repository;

import com.example.coursemanagement.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findAllByCourseId(Long courseId);
    List<Enrollment> findAllByStudentId(Long studentId);
}
