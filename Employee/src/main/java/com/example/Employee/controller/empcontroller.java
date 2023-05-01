package com.example.Employee.controller;

import com.example.Employee.model.Emp;
import com.example.Employee.service.Empservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class empcontroller {

    @Autowired
    private Empservice empservices;

        @PostMapping("/emps")
        public Emp address(@RequestBody Emp employee) {
            return empservices.address(employee);
        }
        @GetMapping("/employe")
        public List<Emp> getAllEmployee(){
            return empservices.getEntity();
        }
        @GetMapping("/employe/{empId}")
        public Emp getEmployeeById(@PathVariable String  empId){
            return empservices.findByempId(empId);
        }
        @DeleteMapping("/deleteemployee/{id}")
        public String deleteEmployee(@PathVariable int  id){
            return empservices.deleteEmployee(id);
        }
    }


