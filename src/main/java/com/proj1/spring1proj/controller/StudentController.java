package com.proj1.spring1proj.controller;

import com.proj1.spring1proj.model.Student;
import com.proj1.spring1proj.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student updatedStudent){
        return studentService.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student Successfully Deleted";
    }

    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String keyword){

        return studentService.searchStudents(keyword);
    }

    @GetMapping("/pages")
    public Page<Student> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "studentNumber") String sortBy,
            @RequestParam(defaultValue = "asc") String direction){
        return studentService.getStudents(page, size, sortBy, direction);
    }




}
