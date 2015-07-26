/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao.impl;

import com.project.constants.SQLCommand;
import com.project.dao.JobDAO;
import com.project.entity.Applicant;
import com.project.entity.Company;
import com.project.entity.Job;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kripesh
 */
@Repository
public class JobDAOImpl implements JobDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public JobDAOImpl(){
        
    }
    @Override
    public int insert(Job j) {
        return jdbcTemplate.update(SQLCommand.JOB_INSERT, new Object[]{j.getCompanyId(),j.getJobTitle(),j.getJobDescription(),j.getPostedDate(),j.getPostingCloseDate(),j.getStatus()});
    }

    @Override
    public int update(Job j) {
        return jdbcTemplate.update(SQLCommand.JOB_UPDATE, new Object[]{j.getCompanyId(),j.getJobTitle(),j.getJobDescription(),j.getPostingCloseDate(),j.getStatus(),j.getJobId()});
    }

    @Override
    public int delete(int jobId) {
        return jdbcTemplate.update(SQLCommand.JOB_DELETE, new Object[]{jobId});
    }

    @Override
    public List<Job> getAll() {
        return jdbcTemplate.query(SQLCommand.JOB_GETALL, new RowMapper<Job>() {

            @Override
            public Job mapRow(ResultSet rs, int i) throws SQLException {
                Job job=new Job();
                job.setJobId(rs.getInt("job_id"));
                job.setCompanyId(rs.getInt("company_id"));
                job.setJobTitle(rs.getString("job_title"));
                job.setJobDescription(rs.getString("job_description"));
                job.setPostedDate(rs.getDate("posted_date"));
                job.setPostingCloseDate(rs.getDate("posting_close_date"));
                job.setStatus(rs.getBoolean("status"));
                return job;
            }
        });
    }

    @Override
    public Job getByJobId(int jobId) {
        return jdbcTemplate.query(SQLCommand.JOB_GETBYJOBID, new Object[]{jobId}, new ResultSetExtractor<Job>() {

            @Override
            public Job extractData(ResultSet rs) throws SQLException, DataAccessException {
                Job job = null;
                if(rs.next()){
                    job = new Job();
                    job.setJobId(rs.getInt("job_id"));
                job.setCompanyId(rs.getInt("company_id"));
                job.setJobTitle(rs.getString("job_title"));
                job.setJobDescription(rs.getString("job_description"));
                job.setPostedDate(rs.getDate("posted_date"));
                job.setPostingCloseDate(rs.getDate("posting_close_date"));
                job.setStatus(rs.getBoolean("status"));
                }
                return job;
            }
        });
    }

    @Override
    public Job getByCompanyId(int companyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Job> getJobAndApplicants(String company_id) {
        String sql;
        Object[] arg=null;
        if(company_id==null){
            sql=SQLCommand.JOB_WITHAPPLICANTS;
        }
        else
        {
            sql = SQLCommand.JOB_WITHAPPLICANTS + " AND jobs.company_id=?" ;
            arg=new Object[]{Integer.parseInt(company_id)};
        }
        return jdbcTemplate.query(sql, arg, new RowMapper<Job>() {

            @Override
            public Job mapRow(ResultSet rs, int i) throws SQLException {
                Job job=new Job();
                job.setJobId(rs.getInt("job_id"));
                job.setCompanyId(rs.getInt("company_id"));
                Company company=new Company();
                company.setCompanyName(rs.getString("company_name"));
                company.setCompanyLogo(rs.getString("company_logo"));
                job.setCompany(company);                
                job.setJobTitle(rs.getString("job_title"));
                job.setJobDescription(rs.getString("job_description"));
                job.setPostedDate(rs.getDate("posted_date"));
                job.setPostingCloseDate(rs.getDate("posting_close_date"));
                job.setStatus(rs.getBoolean("status"));
                job.setTotalApplicants(rs.getInt("total_applicants"));
                return job;
            }
        });
    }

    @Override
    public List<Job> getJobWithCompany() {
        return jdbcTemplate.query(SQLCommand.JOB_COMPANY_JOIN, new RowMapper<Job>() {

            @Override
            public Job mapRow(ResultSet rs, int i) throws SQLException {
                Job job=new Job();
                job.setJobId(rs.getInt("job_id"));
                //job.setCompanyId(rs.getInt("company_id"));
                Company company=new Company();
                company.setCompanyName(rs.getString("company_name"));
                company.setCompanyLogo(rs.getString("company_logo"));
                job.setCompany(company);
                job.setJobTitle(rs.getString("job_title"));
                job.setJobDescription(rs.getString("job_description"));
                job.setPostedDate(rs.getDate("posted_date"));
                job.setPostingCloseDate(rs.getDate("posting_close_date"));
                job.setStatus(rs.getBoolean("status"));
                return job;
            }
        });
    }
    
}
