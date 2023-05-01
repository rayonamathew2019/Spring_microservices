package com.example.Employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="emp_tab")

public class Emp {
    @Id
    @GeneratedValue
    private int id;
    private String empId;
    private String emp_name;
    private String emp_email;
    private String designation;
    private String hr;

}
