package com.appkobo.campusnavi.controller;

import com.appkobo.campusnavi.model.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getCourses(@RequestParam(required = false) Long professorId, @RequestParam(required = false) Long schoolId, @RequestParam(required = false) String query) {
        return ResponseEntity.ok().build();
    }
}
