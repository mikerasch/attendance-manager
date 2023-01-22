package com.studentportal.student;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Integer id){
        super("Student Doest not exist "+id);
    }

}
