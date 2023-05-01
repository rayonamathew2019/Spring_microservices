package com.example.SpringBootTestDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
   // @GeneratedValue
    @Column(name="Id")
    private Integer id;
    @NotBlank
    @Column(name="Name")

    private String name;
    @Column(name="Address")

    private String address;
    @Column(name="Rollno")

    private String rollNo;


}
