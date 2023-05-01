package com.example.Student1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String studentid;
    private String name;
    private String email;
    private int experience;
    @ElementCollection
    private List<String> course;
    private String address;
    private String comments;


}
