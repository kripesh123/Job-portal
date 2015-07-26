/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.entity.Schedule;
import java.util.List;

/**
 *
 * @author Kripesh
 */
public interface ScheduleDAO {
    public int insert(Schedule schedule);
    public int update(Schedule schedule);
    public int delete(int scheduleId);
    public List<Schedule>getAll();
    public Schedule getByScheduleId(int scheduleId);
    public Schedule getByApplicantId(int applicantId);
    public Schedule getByRoleId(int roleId);
    public List<Schedule>getScheduleWithApplicantAndRole(String interviewer);
}
