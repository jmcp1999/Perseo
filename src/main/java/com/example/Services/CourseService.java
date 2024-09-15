package com.example.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Models.Course;
import com.example.Repositories.ICourseRepository;

@Service
public class CourseService {
    @Autowired ICourseRepository iCourseRepository;

    public Course createCourse(Course newCourse) {
      return iCourseRepository.save(newCourse);
    }
  
    public List<Course> getAllCourse() {
      return (List<Course>) iCourseRepository.findAll();
    }
  
    public Optional<Course> getCoursebyId(int id) {
      Course course = iCourseRepository.findById(id).orElseThrow();
      return Optional.of(course);
    }
  
    public void updateCourse(Course course, int id) {
      course.setId(id);
      iCourseRepository.save(course);
    }
  
    public void deleteCourse(int id) {
      iCourseRepository.deleteById(id);
    }
  }