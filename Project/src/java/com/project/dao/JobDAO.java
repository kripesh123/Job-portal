/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.entity.Job;
import java.util.List;

/**
 *
 * @author Kripesh
 */
public interface JobDAO {
    public int insert(Job job);
    public int update(Job job);
    public int delete(int jobId);
    public List<Job>getAll();
    public Job getByJobId(int jobId);
    public Job getByCompanyId(int companyId);
    public List<Job> getJobAndApplicants(String company_id);
    public List<Job>getJobWithCompany();
}
