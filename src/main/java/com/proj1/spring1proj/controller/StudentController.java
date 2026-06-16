package com.proj1.spring1proj.controller;

import com.proj1.spring1proj.model.Student;
import com.proj1.spring1proj.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    /* NB: Will be reimplemted using StudentRespository
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent){
        for (Student student : students){
            if (student.getId().equals(id)){
                student.setFirstName(updatedStudent.getFirstName());
                student.setLastName(updatedStudent.getLastName());
                student.setAge(updatedStudent.getAge());
                student.setCourse(updatedStudent.getCourse());
            }
        }
        return updatedStudent;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        for(Student student: students){
            if(student.getId().equals(id)){
                students.remove(student);
                return "Student successfully deleted";

            }
        }
        return "Student not found";
    }

     */


}
