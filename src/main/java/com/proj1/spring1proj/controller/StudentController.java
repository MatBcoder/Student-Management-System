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

    /*@GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }*/

    @GetMapping()
    public Page<Student> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "studentNumber") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "") String keyword){
        return studentService.getStudents(page, size, sortBy, direction, keyword);
    }

    @GetMapping("/{studentNumber}")
    public Student getStudentByStudentNumber(@PathVariable String studentNumber){
        return studentService.getStudentByStudentNumber(studentNumber);
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{studentNumber}")
    public Student updateStudent(@PathVariable String studentNumber, @Valid @RequestBody Student updatedStudent){
        return studentService.updateStudent(studentNumber, updatedStudent);
    }

    @DeleteMapping("/{studentNumber}")
    public String deleteStudent(@PathVariable String studentNumber){
        studentService.deleteStudent(studentNumber);
        return "Student Successfully Deleted";
    }

    /*@GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String keyword){

        return studentService.searchStudents(keyword);
    }*/


}
