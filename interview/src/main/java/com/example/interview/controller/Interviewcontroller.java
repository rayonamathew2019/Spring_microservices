package com.example.interview.controller;


import com.example.interview.model.Interview;
import com.example.interview.service.Interservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interview")

public class Interviewcontroller {

    @Autowired
    private Interservice intservices;

    @PostMapping("/inte")
    public Interview adddetails(@RequestBody Interview interview) {
        return intservices.createEntity(interview);
    }
    @GetMapping("/inter")
    public List<Interview> getAllInterview(){
        return intservices.getEntity();
    }
    @GetMapping("/inter/{id}")
    public Interview getEmployeeById(@PathVariable int id){
        return intservices.findById(id);
    }
//    @DeleteMapping("/deleteemployee/{id}")
//    public String deleteEmployee(@PathVariable int  id){
//        return empservices.deleteEmployee(id);
//    }
}
