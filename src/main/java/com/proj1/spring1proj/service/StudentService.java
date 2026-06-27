package com.proj1.spring1proj.service;

import com.proj1.spring1proj.exception.StudentNotFoundException;
import com.proj1.spring1proj.model.Student;
import com.proj1.spring1proj.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){

        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        Student savedStudent = studentRepository.save(student);

        String studentNumber = String.format("ST%06d", savedStudent.getId());

        savedStudent.setStudentNumber(studentNumber);
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setAge(updatedStudent.getAge());
        student.setCourse(updatedStudent.getCourse());

        return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public void deleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }

        studentRepository.deleteById(id);
    }

    public List<Student> searchStudents(String keyword){
        return studentRepository.findByStudentNumberContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(keyword, keyword, keyword);
    }

    public Page<Student> getStudents(int page, int size, String sortBy, String direction){
        Sort sort = direction.equalsIgnoreCase("desc")? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return studentRepository.findAll(pageable);
    }
}




