package com.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.service.StudentService;
import com.example.model.*;
import com.example.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
   
    @GetMapping("/batch/{batchId}")
    public List<Student> getStudentsByBatch(@PathVariable Long batchId) {
        return service.getStudentsByBatch(batchId);
    }
}