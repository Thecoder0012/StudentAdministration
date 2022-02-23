package com.studentmanagement.services;

import com.studentmanagement.models.Student;
import com.studentmanagement.repository.StudentRepository;

import java.util.List;
@org.springframework.stereotype.Service
public class StudentService {


    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }


    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
