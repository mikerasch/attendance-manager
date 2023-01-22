package com.studentportal.student;
import com.studentportal.student.subject.SubjectAlreadyExistException;
import com.studentportal.student.subject.SubjectNotFoundException;
import com.studentportal.student.subject.Subjects;
import com.studentportal.student.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;


    //method to get all students
    public Iterable<Student> getAllStudent() {
        //ArrayList<Student> students = new ArrayList<>();
        System.out.println("this is service class");
        return studentRepository.findAll();
    }


    //register new user
    public String register(Student student){
       // student.addRole(new Role("role_user"));
        studentRepository.save(student);
        return "User saved successfully";
    }


    //get student
    public Student getStudent(Integer id){
        return studentRepository.findById(id).orElse(null);

    }


    //add student
    public String addStudent(Student student){
        //check if account already exists
        Iterable<Student> students = studentRepository.findAll();

        for(Student stud: students){
            if(stud.getEmail().equals(student.getEmail())){
                throw new StudentAlreadyExistException(student.getEmail());
            }
        }

        System.out.println(student.getName());

       studentRepository.save(student);
       return "Student saved successfully";
    }

    //delete student

    public String deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return "student deleted from record";
    }


    //update student

    public String updateStudent(Student student, Integer id){
        Student studentToBeUpdated = studentRepository.findById(id).get();
        studentToBeUpdated.setName(student.getName());
        studentToBeUpdated.setCollege(student.getCollege());
        studentToBeUpdated.setEmail(student.getEmail());
        studentToBeUpdated.setNoOfSubjects(student.getNoOfSubjects());
        studentToBeUpdated.setPassword(student.getPassword());
        studentRepository.save(studentToBeUpdated);
        return "Student record updated";
    }


    //adding and removing subjects
    public String addSubject(Integer id, Subjects subject) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }

        //changes to check whether subject already exists
        Iterable<Subjects> subjects = subjectRepository.getSubjectsByStudId(id);

        for(Subjects sub: subjects){
            if(sub.getSubName().equals(subject.getSubName())){
                throw new SubjectAlreadyExistException(subject.getSubName());
            }
        }

        subject.setStudent(studentRepository.findById(id).get());
        subjectRepository.save(subject);
        return "Subject successfully added";
    }
//get subjects by student id
    public Iterable<Subjects> getSubjects(Integer id){
        Iterable<Subjects> subjects =subjectRepository.getSubjectsByStudId(id);
        return subjects;
    }

    public String removeSubject(Integer subid) {
        if(subjectRepository.findById(subid).isPresent()){
            subjectRepository.delete(subjectRepository.findById(subid).get());
            return "Subject removed successfully";
        }


        throw new SubjectNotFoundException(subid);

    }


    //increment or decrement methods

    public String attendedClass(Integer subid){
        Subjects ExistingSubject = subjectRepository.findById(subid).get();
        ExistingSubject.setClassesAttended(ExistingSubject.getClassesAttended()+1);
        ExistingSubject.setTotalClasses(ExistingSubject.getTotalClasses()+1);
        subjectRepository.save(ExistingSubject);
        return "updated attendance records";

    }

    public String notAttendedClass(Integer subid){
        Subjects ExistingSubject = subjectRepository.findById(subid).get();
        ExistingSubject.setTotalClasses(ExistingSubject.getTotalClasses()+1);
        subjectRepository.save(ExistingSubject);
        return "updated attendance records";
    }


    //to change total no of classes and attended classes

    public String setTotalClasses(Integer subid, Integer value){
        Subjects ExistingSubject  = subjectRepository.findById(subid).get();
        ExistingSubject.setTotalClasses(value);
        subjectRepository.save(ExistingSubject);
        return "Total classes set to: "+value;
    }


    public String setClassesAttended(Integer subid, Integer value){
        Subjects ExistingSubject = subjectRepository.findById(subid).get();
        ExistingSubject.setClassesAttended(value);
        subjectRepository.save(ExistingSubject);
        return "Classes Attended are set to: "+value;
    }


}
