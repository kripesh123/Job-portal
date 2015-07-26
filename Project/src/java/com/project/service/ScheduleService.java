/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.dao.ScheduleDAO;
import com.project.entity.Schedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ScheduleService {

    @Autowired
    private ScheduleDAO sdao;

    public int insert(Schedule schedule) {
        return sdao.insert(schedule);
    }

    public int update(Schedule schedule) {
        return sdao.update(schedule);
    }

    public int delete(int scheduleId) {
        return sdao.delete(scheduleId);
    }

    public List<Schedule> getAll() {
        return sdao.getAll();
    }

    public Schedule getByScheduleId(int scheduleId) {
        return sdao.getByScheduleId(scheduleId);
    }

    public Schedule getByApplicantId(int applicantId) {
        return sdao.getByApplicantId(applicantId);
    }

    public Schedule getByRoleId(int roleId) {
        return sdao.getByRoleId(roleId);
    }

     public List<Schedule>getScheduleWithApplicantAndRole(String interviewer){
         return sdao.getScheduleWithApplicantAndRole(interviewer);
     } 
}
