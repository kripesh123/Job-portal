/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao.impl;

import com.project.constants.SQLCommand;
import com.project.dao.ApplicantDAO;
import com.project.entity.Applicant;
import com.project.entity.Job;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
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
public class ApplicantDAOImpl  implements ApplicantDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
   public ApplicantDAOImpl(){
       
   }
    
    @Override
    public int insert(Applicant a) {   
        return jdbcTemplate.update(SQLCommand.APPLICANT_INSERT, new Object[]{a.getJobId(),a.getFirstName(),a.getLastName(),a.getEmail(),a.getContactNo(),a.getCoverLetter(),a.getResume(),a.getApplyDate(),a.getApplicationStatus(),a.getRemarks()});
    }

    @Override
    public int update(Applicant a) {
        return jdbcTemplate.update(SQLCommand.APPLICANT_UPDATE, new Object[]{a.getApplicationStatus(),a.getRemarks(),a.getEditDate(),a.getApplicantId()});
    }

    @Override
    public int delete(int applicantId) {
        return jdbcTemplate.update(SQLCommand.APPLICANT_DELETE,new Object[]{applicantId});
    }

    @Override
    public List<Applicant> getAll() {
        return jdbcTemplate.query(SQLCommand.APPLICANT_GETALL, new RowMapper<Applicant>() {

            @Override
            public Applicant mapRow(ResultSet rs, int i) throws SQLException {
                Applicant applicant=new Applicant();
                applicant.setApplicantId(rs.getInt("applicant_id"));
                applicant.setApplicationStatus(rs.getString("application_status"));
                applicant.setApplyDate(rs.getDate("apply_date"));
                applicant.setContactNo(rs.getString("contact_no"));
                applicant.setEditDate(rs.getDate("edit_date"));
                applicant.setCoverLetter(rs.getString("cover_letter"));
                applicant.setEmail(rs.getString("email"));
                applicant.setFirstName(rs.getString("first_name"));
                applicant.setJobId(rs.getInt("job_id"));
                applicant.setLastName(rs.getString("last_name"));
                applicant.setRemarks(rs.getString("remarks"));
                applicant.setResume(rs.getString("resume"));
                return applicant;
            }
        });
    }

    @Override
    public Applicant getByApplicantId(int applicantId) {
        return jdbcTemplate.query(SQLCommand.APPLICANT_GETBYAPPLICANTID, new Object[]{applicantId}, new ResultSetExtractor<Applicant>() {

            @Override
            public Applicant extractData(ResultSet rs) throws SQLException, DataAccessException {
                 Applicant applicant =null;
                if(rs.next()){
                    applicant = new Applicant();
                    applicant.setApplicantId(rs.getInt("applicant_id"));
                    applicant.setJobId(rs.getInt("job_id"));
                    applicant.setFirstName(rs.getString("first_name"));
                    applicant.setLastName(rs.getString("last_name"));
                    applicant.setEmail(rs.getString("email"));
                    applicant.setContactNo(rs.getString("contact_no"));
                    applicant.setCoverLetter(rs.getString("cover_letter"));
                    applicant.setResume(rs.getString("resume"));
                    applicant.setApplicationStatus(rs.getString("application_status"));
                    applicant.setRemarks(rs.getString("remarks"));
                    
                }
                return applicant;
            }
        });
    }

    @Override
    public Applicant getByJobId(int jobId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Applicant> getApplicantsWithJob(String job_id) {
        String sql;
        Object[] arg=null;
        if(job_id==null){
            sql=SQLCommand.APPLICANT_JOB_JOIN;
        }
        else
        {
            sql=SQLCommand.APPLICANT_JOB_JOIN + " AND applicants.job_id=?";
            arg=new Object[]{Integer.parseInt(job_id)};
        }
        return jdbcTemplate.query(sql, arg, new RowMapper<Applicant>() {
            @Override
            public Applicant mapRow(ResultSet rs, int i) throws SQLException {
                Applicant applicant=new Applicant();
                applicant.setApplicantId(rs.getInt("applicant_id"));
                applicant.setApplicationStatus(rs.getString("application_status"));
                applicant.setApplyDate(rs.getDate("apply_date"));
                applicant.setContactNo(rs.getString("contact_no"));
                applicant.setEditDate(rs.getDate("edit_date"));
                applicant.setCoverLetter(rs.getString("cover_letter"));
                applicant.setEmail(rs.getString("email"));
                applicant.setFirstName(rs.getString("first_name"));
                //applicant.setJobId(rs.getInt("job_id"));
                Job job=new Job();
                job.setJobTitle(rs.getString("job_title"));
                applicant.setJob(job);
                applicant.setLastName(rs.getString("last_name"));
                applicant.setRemarks(rs.getString("remarks"));
                applicant.setResume(rs.getString("resume"));
                return applicant;
            }
        });        
    } 
}
