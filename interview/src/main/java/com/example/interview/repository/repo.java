package com.example.interview.repository;

import com.example.interview.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface repo extends JpaRepository<Interview,Integer> {
}
