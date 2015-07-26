/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.entity.Schedule;
import com.project.service.ApplicantService;
import com.project.service.RoleService;
import com.project.service.ScheduleService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kripesh
 */
@Controller
@RequestMapping(value = "admin/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map,HttpServletRequest request) {
        String interviewer=null;
        if(request.getParameter("interviewer")!=null && !request.getParameter("interviewer").equals(""))
        {
            interviewer=request.getParameter("interviewer");
        }
        map.addAttribute("schedule", scheduleService.getScheduleWithApplicantAndRole(interviewer));
        map.addAttribute("roles", roleService.getAll());
        return "schedule/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(@ModelAttribute(value = "Schedule") Schedule schedule) {
        ModelAndView mv = new ModelAndView("schedule/add");
        mv.addObject("applicants", applicantService.getAll());
        mv.addObject("roles", roleService.getAll());
        return mv;
    }
    
       @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable(value = "id") int id) {
        ModelAndView mv = new ModelAndView("schedule/detail");
        mv.addObject("sch", scheduleService.getByScheduleId(id));
        return mv;   
    }

    /*@RequestMapping(value = "save",method = RequestMethod.POST)
     public @ResponseBody String save(@ModelAttribute(value = "Schedule")Schedule schedule){
     System.out.println(schedule.toString());
     sdao.insert(schedule);
     //return "redirect:/admin/schedule";
     return "schedule";
     }*/
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute(value = "Schedule") Schedule schedule, @Context HttpServletRequest request) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        schedule.setScheduleDate(calendar.getTime());
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate = formatDate.parse(request.getParameter("schedule_date"));
        schedule.setScheduleDate(formatedDate);
        
        schedule.setScheduleTime(calendar.getTime());
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        Date SimpleDateFormat=sdf.parse(request.getParameter("schedule_time"));
        schedule.setScheduleTime(SimpleDateFormat);
        scheduleService.insert(schedule);
        return "redirect:/admin/schedule";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute(value = "Schedule") Schedule schedule, @Context HttpServletRequest request) {
        int scheduleId = Integer.parseInt(request.getParameter("id"));
        scheduleService.delete(scheduleId);
        return "redirect:/admin/schedule";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute(value = "Schedule") Schedule schedule, @Context HttpServletRequest request) {
        ModelAndView mv = null;
        int id = Integer.parseInt(request.getParameter("id"));
        Schedule sch = scheduleService.getByScheduleId(id);
        if (sch != null) {
            mv = new ModelAndView("schedule/edit");
            mv.addObject("schedule", sch);
            mv.addObject("applicant", applicantService.getByApplicantId(sch.getApplicantId()));
            mv.addObject("applicants", applicantService.getAll());
            mv.addObject("role", roleService.getByRoleId(sch.getInterviewer()));
            mv.addObject("roles", roleService.getAll());
        }
        return mv;
    }
    
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "Schedule")Schedule schedule,@Context HttpServletRequest request) throws ParseException{
        schedule.setScheduleId(Integer.parseInt(request.getParameter("id")));
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate = formatDate.parse(request.getParameter("schedule_date"));
        schedule.setScheduleDate(formatedDate);
       
       
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        Date SimpleDateFormat=sdf.parse(request.getParameter("schedule_time"));
        schedule.setScheduleTime(SimpleDateFormat);
        
        Calendar calendar=Calendar.getInstance();
        schedule.setEditDate(calendar.getTime());
        scheduleService.update(schedule);
        return "redirect:/admin/schedule";
    }

}
