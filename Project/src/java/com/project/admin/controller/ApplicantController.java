/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.controller;

import com.project.dao.ApplicantDAO;
import com.project.dao.JobDAO;
import com.project.dao.impl.ApplicantDAOImpl;
import com.project.entity.Applicant;
import com.project.service.ApplicantService;
import com.project.service.JobService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kripesh
 */
@Controller
@RequestMapping(value = "admin/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private JobService jobService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map,HttpServletRequest request) {
        String job_id=null;
        if(request.getParameter("job_id")!=null && !request.getParameter("job_id").equals("")){
            job_id=request.getParameter("job_id");
        }
        map.addAttribute("applicants", applicantService.getApplicantsWithJob(job_id));
        map.addAttribute("jobs", jobService.getAll());
        
        return "adminApplicant/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(@ModelAttribute(value = "Applicant") Applicant applicant) {
        ModelAndView mv = new ModelAndView("adminApplicant/add");
        mv.addObject("jobs", jobService.getAll());
        return mv;
    
    }
        @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable(value = "id") int id) {
        ModelAndView mv = new ModelAndView("adminApplicant/detail");
        mv.addObject("app", applicantService.getByApplicantId(id));
        return mv;
    }
        

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute(value = "Applicant") Applicant applicant, @RequestParam("name") String[] names,
            @RequestParam("file") MultipartFile[] files) {
        String message = "";
        if (files.length != names.length){
            
        }
 
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];
            try {
                byte[] bytes = file.getBytes();
 
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "Applicants Documents" + File.separator  + applicant.getFirstName()+" "+applicant.getContactNo());
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                System.out.println("FilePath"+ serverFile.getAbsolutePath());
 
                message = message + "You successfully uploaded file=" + name
                        + "<br />";
                System.out.println(message);
                if(message.contains("successfully")){
                    applicant.setResume(serverFile+"/"+names[0]);
                    applicant.setCoverLetter(serverFile+"/"+names[1]);
                    Calendar calendar = Calendar.getInstance();
                    applicant.setApplyDate(calendar.getTime());
                     applicantService.insert(applicant);
                }
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        
        return "redirect:/admin/applicant";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute(value = "Applicant") Applicant applicant, @Context HttpServletRequest request) {
        int applicantId = Integer.parseInt(request.getParameter("applicant_id"));
        applicantService.delete(applicantId);
        return "redirect:/admin/applicant";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute(value = "Applicant") Applicant applicant, @Context HttpServletRequest request) {
        ModelAndView mv = null;
        int id = Integer.parseInt(request.getParameter("id"));
        Applicant app = applicantService.getByApplicantId(id);
        if(app!=null){
          mv   = new ModelAndView("adminApplicant/edit");
          mv.addObject("job", jobService.getByJobId(app.getJobId()));
           mv.addObject("jobs", jobService.getAll());
          mv.addObject("applicant", app);
        }
        return mv;
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "Applicant") Applicant applicant, @Context HttpServletRequest request) {
        applicant.setApplicantId(Integer.parseInt(request.getParameter("id")));
        Calendar calendar = Calendar.getInstance();
        applicant.setEditDate(calendar.getTime());
        applicantService.update(applicant);
        return "redirect:/admin/applicant";
    }
    
    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String uploadFile(){
        return "adminApplicant/upload";
    }
    
    @RequestMapping(value = "uploadMultiple", method = RequestMethod.GET)
    public String uploadMultipleFile(){
        return "adminApplicant/uploadMultiple";
    }
    

}
