package com.example.Student1.Controller;

import com.example.Student1.Entity.Student;
import com.example.Student1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student addstudent(@RequestBody Student student){
        return studentService.addstudent(student);

    }
    @GetMapping("/students")
    public List<Student> getallstudents(){
        return studentService.getall();
    }

    @GetMapping("/students/{course}")
    public Long getstudentBycourse(@PathVariable String course)
    {
        return studentService.getStudentBycourse(course);
    }
    @GetMapping
    public List<Student> getbyaddress(@PathVariable String address){
        return studentService.getbyaddress(address);
    }



}
