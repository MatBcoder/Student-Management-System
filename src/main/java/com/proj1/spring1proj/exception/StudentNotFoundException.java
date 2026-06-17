package com.proj1.spring1proj.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id){
        super("Student With ID "+id+ " Does not Exist");
    }
}
