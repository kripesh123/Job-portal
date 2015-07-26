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
public class Job {
    private int jobId;
    private int companyId;
    private String jobTitle;
    private String jobDescription;
    private Date postedDate;
    private Date postingCloseDate;
    private Boolean status;
    private Company company;
    private int totalApplicants;

    

    public Job() {
    }

    public Job(int jobId, int companyId, String jobTitle, String jobDescription, Date postedDate, Date postingCloseDate, Boolean status) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.postedDate = postedDate;
        this.postingCloseDate = postingCloseDate;
        this.status = status;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getPostingCloseDate() {
        return postingCloseDate;
    }

    public void setPostingCloseDate(Date postingCloseDate) {
        this.postingCloseDate = postingCloseDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    /* only for applicants purpose */
    public int getTotalApplicants() {
        return totalApplicants;
    }

    public void setTotalApplicants(int totalApplicants) {
        this.totalApplicants = totalApplicants;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Job{" + "jobId=" + jobId + ", companyId=" + companyId + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", postedDate=" + postedDate + ", postingCloseDate=" + postingCloseDate + ", status=" + status + ", company=" + company + ", totalApplicants=" + totalApplicants + '}';
    }
    
}
