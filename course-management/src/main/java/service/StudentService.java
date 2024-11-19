package com.example.coursemanagement.service;

import com.example.coursemanagement.model.Student;
import com.example.coursemanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }


    public Student updateStudent(Long studentId, Student updatedStudent) {
        // Check if the student exists before updating
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            updatedStudent.setId(studentId);
            return studentRepository.save(updatedStudent);
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }


    public void deleteStudent(Long studentId) {
        // Check if the student exists before deleting
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            studentRepository.deleteById(studentId);
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }
}
