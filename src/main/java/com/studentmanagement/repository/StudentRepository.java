package com.studentmanagement.repository;

import com.studentmanagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> { // tager imod 2 parametre, entity altså vores table og typen primary key.
}
