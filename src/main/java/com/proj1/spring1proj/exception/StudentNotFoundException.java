package com.proj1.spring1proj.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String studentNumber){
        super("Student With ID "+studentNumber+ " Does not Exist");
    }
}
