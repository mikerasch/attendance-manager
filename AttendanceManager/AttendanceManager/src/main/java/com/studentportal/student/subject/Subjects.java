package com.studentportal.student.subject;

import com.studentportal.student.Student;

import javax.persistence.*;

@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subid")
    private Integer subId;

    @Column(name="subname")
    private String subName;
    @Column(name="totalclasses")
    private int totalClasses;
    @Column(name="classesattended")
    private int classesAttended;
    //private Integer studentId;

    @ManyToOne
    @JoinColumn(name="studid")
    Student student;

    public Subjects(){}

    public Subjects ( String subName, int totalClasses, int classesAttended, Student student){
        //this.subId=subId;
        this.subName=subName;
        this.totalClasses=totalClasses;
        this.classesAttended=classesAttended;
        this.student=student;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getClassesAttended() {
        return classesAttended;
    }

    public void setClassesAttended(int classesAttended) {
        this.classesAttended = classesAttended;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "subId=" + subId +
                ", subName='" + subName + '\'' +
                ", totalClasses=" + totalClasses +
                ", classesAttended=" + classesAttended +
                '}';
    }

    public void setStudent(Student student) {
        this.student=student;
    }

    public Student getStudent(){
        return student;
    }
}
