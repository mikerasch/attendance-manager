package com.studentportal.student.subject;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subjects, Integer> {
    @Query("SELECT sub FROM Subjects sub WHERE sub.student.id =?1")
    public List<Subjects> getSubjectsByStudId(Integer id);
}
