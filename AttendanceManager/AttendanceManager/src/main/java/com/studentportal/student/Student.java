package com.studentportal.student;

import com.studentportal.student.subject.Subjects;

import javax.persistence.*;
import java.util.*;


//mapping our object with table
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="studentname")
    private String studentName;

    @Column(name="email")
    private String email;

    @Column(name = "studentpassword")
    private String studentPassword;

    @Column(name = "college")
    private String college;

    @Column(name = "noofsubjects")
    private int noOfSubjects;



//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Subjects> subjects = new ArrayList<>();
//
//    //new code here
//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();
//
//    public void addRole(Role role) {
//        this.roles.add(role);
//    }
// end of new code

//    public Student( String studentName, String email, String studentPassword,String college, int noOfSubjects) {
//        this.studentName = studentName;
//        this.email = email;
//        this.studentPassword = studentPassword;
//        this.college=college;
//        this.noOfSubjects = noOfSubjects;
//    }



  public Student(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){this.id=id;}

    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return studentPassword;
    }

    public void setPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getNoOfSubjects() {
        return noOfSubjects;
    }

    public void setNoOfSubjects(int noOfSubjects) {
        this.noOfSubjects = noOfSubjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", noOfSubjects=" + noOfSubjects +
                '}';
    }
}
