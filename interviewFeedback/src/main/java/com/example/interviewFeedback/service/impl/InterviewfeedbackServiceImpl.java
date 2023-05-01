package com.example.interviewFeedback.service.impl;

import com.example.interviewFeedback.dao.InterviewfeedbackRepository;
import com.example.interviewFeedback.dto.InterviewfeedbackDTO;
import com.example.interviewFeedback.entity.Interviewfeedback;
import com.example.interviewFeedback.mapper.InterviewfeedbackMapper;
import com.example.interviewFeedback.service.InterviewfeedbackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InterviewfeedbackServiceImpl implements InterviewfeedbackService {
    private final InterviewfeedbackRepository repository;

    public InterviewfeedbackServiceImpl(InterviewfeedbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public Interviewfeedback save(Interviewfeedback entity) {
        return repository.save(entity);
    }

    @Override
    public List<Interviewfeedback> save(List<Interviewfeedback> entities) {
        return (List<Interviewfeedback>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Interviewfeedback> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Interviewfeedback> findAll() {
        return (List<Interviewfeedback>) repository.findAll();
    }

    @Override
    public Page<Interviewfeedback> findAll(Pageable pageable) {
        Page<Interviewfeedback> entityPage = repository.findAll(pageable);
        List<Interviewfeedback> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Interviewfeedback update(Interviewfeedback entity, Long id) {
        Optional<Interviewfeedback> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}