/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;

import java.util.Date;

/**
 *
 * @author Kripesh
 */
public class Schedule {
    private int scheduleId;
    private int applicantId;
    private Date scheduleDate;
    private Date scheduleTime;
    private int interviewer;
    private Date editDate;
    private String messageForApplicant;
    private String messageForInterviewer;
    private Boolean scheduleStatus;
    private String remarks;
    private Applicant applicant;
    private Role role;

    public Schedule() {
    }

    public Schedule(int scheduleId, int applicantId, Date scheduleDate, Date scheduleTime, int interviewer, String messageForApplicant, String messageForInterviewer, Boolean scheduleStatus, String remarks) {
        this.scheduleId = scheduleId;
        this.applicantId = applicantId;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.interviewer = interviewer;
        this.messageForApplicant = messageForApplicant;
        this.messageForInterviewer = messageForInterviewer;
        this.scheduleStatus = scheduleStatus;
        this.remarks = remarks;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public int getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(int interviewer) {
        this.interviewer = interviewer;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getMessageForApplicant() {
        return messageForApplicant;
    }

    public void setMessageForApplicant(String messageForApplicant) {
        this.messageForApplicant = messageForApplicant;
    }

    public String getMessageForInterviewer() {
        return messageForInterviewer;
    }

    public void setMessageForInterviewer(String messageForInterviewer) {
        this.messageForInterviewer = messageForInterviewer;
    }

    public Boolean getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(Boolean scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Schedule{" + "scheduleId=" + scheduleId + ", applicantId=" + applicantId + ", scheduleDate=" + scheduleDate + ", scheduleTime=" + scheduleTime + ", interviewer=" + interviewer + ", messageForApplicant=" + messageForApplicant + ", messageForInterviewer=" + messageForInterviewer + ", scheduleStatus=" + scheduleStatus + ", remarks=" + remarks + ", applicant=" + applicant + ", role=" + role + '}';
    }

    
    

   
}
