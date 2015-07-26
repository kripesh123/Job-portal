/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.dao.ApplicantDAO;
import com.project.entity.Applicant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ApplicantService {
    
   @Autowired
    private ApplicantDAO adao;
    
    public List<Applicant>getAll(){
        return adao.getAll();
    }
    public int insert(Applicant applicant){
        return adao.insert(applicant);
    }
    public int update(Applicant applicant){
        return adao.update(applicant);
    }
    public int delete(int applicantId){
        return adao.delete(applicantId);
    }
    public Applicant getByApplicantId(int applicantId){
        return adao.getByApplicantId(applicantId);
    }
    public Applicant getByJobId(int jobId){
        return adao.getByJobId(jobId);
    }
     public List<Applicant> getApplicantsWithJob(String job_id){
         return adao.getApplicantsWithJob(job_id);
     }
    
}
