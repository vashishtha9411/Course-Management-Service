package com.example.coursemanagement.service;

import com.example.coursemanagement.model.Teacher;
import com.example.coursemanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId);  // Returns Optional<Teacher>
    }

    public Teacher updateTeacher(Long teacherId, Teacher updatedTeacher) {
        if (teacherRepository.existsById(teacherId)) {
            updatedTeacher.setId(teacherId);
            return teacherRepository.save(updatedTeacher);
        }
        return null;
    }

    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
