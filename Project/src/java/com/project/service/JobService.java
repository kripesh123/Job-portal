/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.dao.JobDAO;
import com.project.entity.Job;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class JobService {
    @Autowired
    private JobDAO jdao;
    
    public List<Job>getAll(){
        return jdao.getAll();
    }
    public int insert(Job job){
        return jdao.insert(job);
    }
    public int update(Job Job){
        return jdao.update(Job);
    }
    public int delete(int jobId){
        return jdao.delete(jobId);
    }
    public Job getByJobId(int jobId){
        return jdao.getByJobId(jobId);
    }
    public Job getByCompanyId(int companyId){
        return jdao.getByCompanyId(companyId);
    }
    public List<Job>getJobAndApplicants(String company_id){
        return jdao.getJobAndApplicants(company_id);
    }
    public List<Job>getJobWithCompany(){
        return jdao.getJobWithCompany();
    }
}
