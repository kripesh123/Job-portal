/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.dao.CompanyDAO;
import com.project.dao.JobDAO;
import com.project.dao.impl.JobDAOImpl;
import com.project.entity.Job;
import com.project.service.CompanyService;
import com.project.service.JobService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kripesh
 */
@Controller
@RequestMapping(value = "admin/job")
public class JobController {

    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map,HttpServletRequest request) {
        String company_id=null;
        if(request.getParameter("company_id")!=null && !request.getParameter("company_id").equals("") )
        {
            company_id=request.getParameter("company_id");
        } 
            map.addAttribute("jobs", jobService.getJobAndApplicants(company_id));
            map.addAttribute("companies", companyService.getAll());
        return "job/index";
    }
    

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(@ModelAttribute("Job") Job job) {
        ModelAndView mv = new ModelAndView("job/add");
        mv.addObject("companys", companyService.getAll());
        return mv;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute(value = "Job") Job job, HttpServletRequest request) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        job.setPostedDate(calendar.getTime());
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate = formatDate.parse(request.getParameter("posting_close_date"));
        job.setPostingCloseDate(formatedDate);
        jobService.insert(job);
        return "redirect:/admin/job";
    }
    
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(@ModelAttribute(value = "Job")Job job,@Context HttpServletRequest request){
        int jobId=Integer.parseInt(request.getParameter("id"));
        jobService.delete(jobId);
        return "redirect:/admin/job";
    }
    
    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute(value = "Job")Job job, @Context HttpServletRequest request){
        ModelAndView mv=null;
        int id= Integer.parseInt(request.getParameter("id"));
        Job j=jobService.getByJobId(id);
        if(j!=null){
            mv=new ModelAndView("job/edit");
            mv.addObject("job", j);
            mv.addObject("company",companyService.getByCompanyId(j.getCompanyId()));
            mv.addObject("companies", companyService.getAll());
        }
        return mv;
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "Job") Job job, @Context HttpServletRequest request) throws ParseException {
        
        job.setJobId(Integer.parseInt(request.getParameter("id")));
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate = formatDate.parse(request.getParameter("posting_close_date"));
        job.setPostingCloseDate(formatedDate);
        jobService.update(job);
        return "redirect:/admin/job";
    }
}
