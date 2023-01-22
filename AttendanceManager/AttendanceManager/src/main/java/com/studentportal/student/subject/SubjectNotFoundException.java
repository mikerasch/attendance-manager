package com.studentportal.student.subject;

public class SubjectNotFoundException extends RuntimeException{
    public SubjectNotFoundException(Integer subid){
        super("Subject does not exists with sub ID "+ subid );
    }

}
