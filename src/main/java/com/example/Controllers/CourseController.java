package com.example.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Models.Course;
import com.example.Services.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/Course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping(path = "post")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @GetMapping(path = "get")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping(path = "get/{id}")
        public Optional<Course> getCoursebyId(@PathVariable int id) {
            return courseService.getCoursebyId(id);
        }

    @PutMapping(path = "put/{id}")
        public void updateCourse(@RequestBody Course course, @PathVariable int id) {
            courseService.updateCourse(course, id);
        }
    
    @DeleteMapping(path = "delete/{id}")
        public void deleteCourse(@PathVariable int id) {
            courseService.deleteCourse(id);
        }
}
