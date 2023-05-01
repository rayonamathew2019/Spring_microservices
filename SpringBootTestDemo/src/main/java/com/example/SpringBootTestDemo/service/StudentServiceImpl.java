package com.example.SpringBootTestDemo.service;

import com.example.SpringBootTestDemo.entity.Student;
import com.example.SpringBootTestDemo.exception.Kevin;
import com.example.SpringBootTestDemo.exception.StudentNotFoundException;
import com.example.SpringBootTestDemo.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentServices{
    @Autowired
    private Studentrepo studentrepo;
    @Override
    public Student addStudent(Student student) {
        Optional<Student> student1= studentrepo.findById(student.getId());
        if(student1.isPresent()){
            throw new Kevin();
        }
        return studentrepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentrepo.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
       var s=studentrepo.findById(id);
       if(s.isEmpty()){
           throw new StudentNotFoundException(id+" is not found");
       }
        return s.get();
    }

    @Override
    public Student deleteStudentById(Integer id) {
        Optional<Student> s=studentrepo.findById(id);
        if(!s.isPresent()){
            throw new StudentNotFoundException("student with id :" +id +"doesn't exist");
        }
        studentrepo.delete((s.get()));
        return null;
    }

    @Override
    public List<Student> getstudentByName(String name) {
        return studentrepo.findByName(name);
    }

}
