package com.studentportal.student;

import com.studentportal.student.subject.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class StudentController {

    //autowired tells spring to inject bean of this class/interface
    //without instantiating explicitly
    @Autowired
    private StudentService studentService;



    //endpoint serving get method to get all students
    @RequestMapping("/students")
    public   Iterable<Student> getAllStudent( ){
       // System.out.println("this guy belongs to controller");
        return studentService.getAllStudent();
    }



    //registering user
    @RequestMapping(method=RequestMethod.POST, value="/register")
        public String register(@RequestBody Student student){
            return studentService.register(student);
        }


    //endpoint to get student with particular id
    @RequestMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudent(id);
    }

    //endpoint to post a new student
    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public String addStudent(@RequestBody  Student student){
        return studentService.addStudent(student);
    }


    //endpoint to delete a record
    @RequestMapping(method=RequestMethod.DELETE,value = "/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/students/{id}")
    public String updateStudent(@RequestBody  Student student, @PathVariable Integer id){
        return studentService.updateStudent(student, id);
    }

   // adding subjects and removing subjects

    @RequestMapping(method=RequestMethod.POST, value="/subjects/{id}")
    public String addSubject(@PathVariable Integer id, @RequestBody Subjects subject)  {
        //check whether user is logged in
        //session in springs
        //validateStudent()
        try {
            return studentService.addSubject(id, subject);
        }
       catch (Exception e){
            return e.getMessage();
       }
    }
//get all subjects by student ID
    @RequestMapping("/subjects/{id}")
    public Iterable<Subjects> getSubjects(@PathVariable Integer id){
        return studentService.getSubjects(id);
    }

    //deleting subjects

    @RequestMapping(method=RequestMethod.DELETE, value="subjects/{subid}")
    public String removeSubject(@PathVariable Integer subid){
        try{
            return studentService.removeSubject(subid);
        }
        catch(Exception e){
            return e.getMessage();
        }

    }
//
//
//    //counters for incrementing or decrementing
//
    @RequestMapping(method=RequestMethod.PUT, value="subjects/attended/{subid}")
    public String attendedClass(@PathVariable Integer subid){
        return studentService.attendedClass(subid);
    }
//
    @RequestMapping(method=RequestMethod.PUT, value="subjects/not-attended/{subid}")
    public String notAttendedClass(@PathVariable Integer subid){
        return studentService.notAttendedClass(subid);
    }


//endpoints for setting classes attended and total classes

    @RequestMapping(method=RequestMethod.PUT, value="subjects/{subid}/set-totalClasses/{value}")
    public String setTotalClasses(@PathVariable Integer subid,@PathVariable Integer value){
        return studentService.setTotalClasses(subid,value);
    }

    @RequestMapping(method=RequestMethod.PUT, value="subjects/{subid}/set-classesAttended/{value}")
    public String setClassesAttended(@PathVariable Integer subid, @PathVariable Integer value){
        return studentService.setClassesAttended(subid,value);
    }

}
