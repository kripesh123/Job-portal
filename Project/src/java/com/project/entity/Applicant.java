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
public class Applicant {
    private int applicantId;
    private int jobId;
    private Job job;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String coverLetter;
    private String resume;
    private Date applyDate;
    private Date editDate;
    private String applicationStatus;
    private String remarks;
   

    public Applicant() {
    }

    public Applicant(int applicantId, int jobId, String firstName, String lastName, String email, String contactNo, String coverLetter, String resume, Date applyDate, Date editDate, String applicationStatus, String remarks) {
        this.applicantId = applicantId;
        this.jobId = jobId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        this.coverLetter = coverLetter;
        this.resume = resume;
        this.applyDate = applyDate;
        this.editDate= editDate;
        this.applicationStatus = applicationStatus;
        this.remarks = remarks;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
    
    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Applicant{" + "applicantId=" + applicantId + ", jobId=" + jobId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNo=" + contactNo + ", coverLetter=" + coverLetter + ", resume=" + resume + ", applyDate=" + applyDate + ", editDate=" + editDate + ", applicationStatus=" + applicationStatus + ", remarks=" + remarks + '}';
    }

    

    
    
}
