package com.example.Employee.service;

import com.example.Employee.model.Emp;
import com.example.Employee.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Empservice {

    @Autowired
    private repo re;

    public Emp address(Emp employee) {
        return re.save(employee);
    }

    public List<Emp> getEntity() {
        return re.findAll();
    }

    public Emp findByempId(String empId) {
        return re.findByempId(empId);
    }

    public String deleteEmployee(int id) {
        re.deleteById((id));
        return "the employee is deleted";
    }
}
