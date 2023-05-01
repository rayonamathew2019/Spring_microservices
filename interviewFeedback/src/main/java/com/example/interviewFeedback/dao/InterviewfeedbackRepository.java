package com.example.interviewFeedback.dao;

import com.example.interviewFeedback.entity.Interviewfeedback;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewfeedbackRepository extends PagingAndSortingRepository<Interviewfeedback, Long> {
}