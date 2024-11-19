package com.example.coursemanagement.service;

import com.example.coursemanagement.model.Course;
import com.example.coursemanagement.model.CourseStatus;
import com.example.coursemanagement.model.Teacher;
import com.example.coursemanagement.repository.CourseRepository;
import com.example.coursemanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public Course createCourse(Course course) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(course.getTeacher().getId());
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            course.setTeacher(teacher);
            course.setStatus(CourseStatus.ACTIVE);  // Set default status to ACTIVE
            teacher.setCourseCount(teacher.getCourseCount() + 1);
            teacherRepository.save(teacher);
            return courseRepository.save(course);
        }
        throw new IllegalArgumentException("Teacher not found with ID: " + course.getTeacher().getId());
    }

    public List<Course> getCoursesByTeacherId(Long teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if (existingCourse.isPresent()) {
            updatedCourse.setId(courseId);
            return courseRepository.save(updatedCourse);
        }
        throw new IllegalArgumentException("Course not found with ID: " + courseId);
    }

    public void deleteCourse(Long courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
        } else {
            throw new IllegalArgumentException("Course not found with ID: " + courseId);
        }
    }
}
