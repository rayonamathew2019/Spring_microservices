package com.example.Employee.repository;

import com.example.Employee.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface repo extends JpaRepository<Emp,Integer> {

    Emp findByempId(String empId);
}
