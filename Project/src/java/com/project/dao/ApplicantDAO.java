/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.entity.Applicant;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Kripesh
 */
public interface ApplicantDAO {
    public int insert(Applicant applicant);
    public int update(Applicant applicant);
    public int delete(int applicantId);
    public List<Applicant>getAll();
    public Applicant getByApplicantId(int applicantId);
    public Applicant getByJobId(int jobId);
    public List<Applicant> getApplicantsWithJob(String job_id);
    
}
