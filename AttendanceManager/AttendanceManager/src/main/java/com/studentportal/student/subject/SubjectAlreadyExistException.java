package com.studentportal.student.subject;

public class SubjectAlreadyExistException extends RuntimeException{
    public SubjectAlreadyExistException(String subName){
        super(subName+" already exists");
    }
}
