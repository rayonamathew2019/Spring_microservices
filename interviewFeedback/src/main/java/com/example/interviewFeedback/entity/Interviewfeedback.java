package com.example.interviewFeedback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class Interviewfeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String userid;
    private String candidateName;
    private String position;
    private String interviewerName;
    private String interviewerEmpid;
    private int rating;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getInterviewerEmpid() {
        return interviewerEmpid;
    }

    public void setInterviewerEmpid(String interviewerEmpid) {
        this.interviewerEmpid = interviewerEmpid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Interviewfeedback(Long id, String userid, String candidateName, String position, String interviewerName, String interviewerEmpid, int rating, String status) {
        this.id = id;
        this.userid = userid;
        this.candidateName = candidateName;
        this.position = position;
        this.interviewerName = interviewerName;
        this.interviewerEmpid = interviewerEmpid;
        this.rating = rating;
        this.status = status;
    }
    public Interviewfeedback(){

    }
}
