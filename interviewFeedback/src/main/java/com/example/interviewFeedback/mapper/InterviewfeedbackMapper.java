package com.example.interviewFeedback.mapper;

import com.example.interviewFeedback.dto.InterviewfeedbackDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface InterviewfeedbackMapper extends GenericMapper<Interviewfeedback, InterviewfeedbackDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Interviewfeedback asEntity(InterviewfeedbackDTO dto);
}