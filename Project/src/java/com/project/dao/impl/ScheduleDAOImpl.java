/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao.impl;

import com.project.constants.SQLCommand;
import com.project.dao.ScheduleDAO;
import com.project.entity.Applicant;
import com.project.entity.Role;
import com.project.entity.Schedule;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ScheduleDAOImpl implements ScheduleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ScheduleDAOImpl() {

    }

    private Schedule mapData(ResultSet rs) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setApplicantId(rs.getInt("applicant_id"));
        schedule.setInterviewer(rs.getInt("interviewer"));
        schedule.setMessageForApplicant(rs.getString("message_for_applicant"));
        schedule.setMessageForInterviewer(rs.getString("message_for_interviewer"));
        schedule.setRemarks(rs.getString("remarks"));
        schedule.setScheduleDate(rs.getDate("schedule_date"));
        schedule.setScheduleTime(rs.getTime("schedule_time"));
        schedule.setEditDate(rs.getDate("edit_date"));
        schedule.setScheduleId(rs.getInt("schedule_id"));
        schedule.setScheduleStatus(rs.getBoolean("schedule_status"));
        /*if(rs.getTime("schedule_time")!=null){
         schedule.setScheduleTime(rs.getTime("schedule_time"));
         }*/
        return schedule;

    }

    @Override
    public int insert(Schedule s) {
        return jdbcTemplate.update(SQLCommand.SCHEDULE_INSERT, new Object[]{s.getApplicantId(), s.getScheduleDate(), s.getScheduleTime(), s.getInterviewer(), s.getMessageForApplicant(), s.getMessageForInterviewer(), s.getScheduleStatus(), s.getRemarks()});
    }

    @Override
    public int update(Schedule s) {
        return jdbcTemplate.update(SQLCommand.SCHEDULE_UPDATE, new Object[]{s.getApplicantId(), s.getScheduleDate(), s.getScheduleTime(), s.getInterviewer(), s.getEditDate(), s.getMessageForApplicant(), s.getMessageForInterviewer(), s.getScheduleStatus(), s.getRemarks(),s.getScheduleId()});
    }

    @Override
    public int delete(int scheduleId) {
        return jdbcTemplate.update(SQLCommand.SCHEDULE_DELETE, new Object[]{scheduleId});
    }

    @Override
    public List<Schedule> getAll() {
        return jdbcTemplate.query(SQLCommand.SCHEDULE_GETALL, new RowMapper<Schedule>() {

            @Override
            public Schedule mapRow(ResultSet rs, int i) throws SQLException {

                return mapData(rs);
            }
        });
    }

    @Override
    public Schedule getByScheduleId(int scheduleId) {
        return jdbcTemplate.query(SQLCommand.SCHEDULE_GETBYSCHEDULEID, new Object[]{scheduleId}, new ResultSetExtractor<Schedule>() {

            @Override
            public Schedule extractData(ResultSet rs) throws SQLException, DataAccessException {
                Schedule schedule = null;
                if (rs.next()) {
                    schedule = mapData(rs);
                }
                return schedule;
            }
        });
    }

    @Override
    public Schedule getByApplicantId(int applicantId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Schedule getByRoleId(int roleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Schedule> getScheduleWithApplicantAndRole(String interviewer) {
        String sql;
        Object[] arg=null;
        if(interviewer==null){
            sql=SQLCommand.SCHEDULE_APPLICANT_ROLE_JOIN;
        }
        else{
            sql=SQLCommand.SCHEDULE_APPLICANT_ROLE_JOIN + " AND schedules.interviewer=?";
             arg=new Object[]{Integer.parseInt(interviewer)};
        }
        return jdbcTemplate.query(sql, arg, new RowMapper<Schedule>() {

           
            @Override
            public Schedule mapRow(ResultSet rs, int i) throws SQLException {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(rs.getInt("schedule_id"));
                schedule.setScheduleDate(rs.getDate("schedule_date"));
                schedule.setScheduleTime(rs.getTime("schedule_time"));
                schedule.setEditDate(rs.getDate("edit_date"));
                //job.setCompanyId(rs.getInt("company_id"));
                Applicant applicant = new Applicant();
                applicant.setFirstName(rs.getString("first_name"));
                applicant.setLastName(rs.getString("last_name"));
                schedule.setApplicant(applicant);

                schedule.setMessageForApplicant(rs.getString("message_for_applicant"));
                schedule.setMessageForInterviewer(rs.getString("message_for_interviewer"));
                schedule.setRemarks(rs.getString("remarks"));

                Role role = new Role();
                role.setRoleName(rs.getString("role_name"));
                schedule.setRole(role);

                schedule.setScheduleStatus(rs.getBoolean("schedule_status"));

                return schedule;
            }
        });
    }
}
