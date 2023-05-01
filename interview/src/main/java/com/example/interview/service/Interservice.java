package com.example.interview.service;

import com.example.interview.model.Interview;
import com.example.interview.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class Interservice {

    @Autowired
    public repo re;

    public List<Interview> getEntity() {
        return re.findAll();
    }

    public Interview createEntity(Interview interview) {
        return re.save(interview);
    }

    public Interview findById(int id) {
        return re.findById(id).orElse(null);
    }
}
