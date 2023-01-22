package com.studentportal.student;

public class StudentAlreadyExistException extends RuntimeException{
    public StudentAlreadyExistException (String email){
        super("This account "+email+" already exists");
    }
}
