package com.studentmanagement.controllers;

import com.studentmanagement.models.Student;
import com.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String studentList(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("addStudents", student);
        return "add-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("addStudents") Student student) {
            studentService.saveStudent(student);
            return "redirect:/students";
        }


    @GetMapping("/students/update/{id}")
    public String updateStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        return "update-student";
    }

    @PostMapping("/students/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {

        Student students = studentService.getStudent(id); // getting the student from the database
        students.setId(id);
        students.setFirstName(student.getFirstName());
        students.setLastName(student.getLastName());
        students.setAge(student.getAge());
        students.setEmail(student.getEmail());
        studentService.saveStudent(students);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
