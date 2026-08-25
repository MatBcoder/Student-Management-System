package com.proj1.spring1proj.repository;

import com.proj1.spring1proj.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student>
    findByStudentNumberContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrCourseContainingIgnoreCase(
            String studentNumber,
            String firstName,
            String lastName,
            String course,
            Pageable pageable);

    Optional <Student> findByStudentNumber (String studentNumber);
}

