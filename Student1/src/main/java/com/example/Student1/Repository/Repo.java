package com.example.Student1.Repository;

import com.example.Student1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Repo extends JpaRepository<Student,Long> {
}
