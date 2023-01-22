package com.studentportal.student;

import com.studentportal.student.subject.Subjects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    // Student findByName(String name);
}
