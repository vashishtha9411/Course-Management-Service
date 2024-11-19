package com.example.coursemanagement.dto;

import com.example.coursemanagement.model.Student;
import com.example.coursemanagement.model.Course;

public class EnrollmentDTO {

    private Long id;
    private Student student;
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
