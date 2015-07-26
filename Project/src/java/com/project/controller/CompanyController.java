/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.dao.CompanyDAO;
import com.project.dao.impl.CompanyDAOImpl;
import com.project.entity.Company;
import com.project.service.CompanyService;
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
@RequestMapping(value = "admin/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
        map.addAttribute("company", companyService.getAll());
        return "company/index";
    }
    
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public ModelAndView add(@ModelAttribute(value = "Company")Company company){
        ModelAndView mv=new ModelAndView("company/add");
        mv.addObject("company", companyService.getAll());
        return mv;
    }
    
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(@ModelAttribute(value = "Company")Company company){
        companyService.insert(company);
        return "redirect:/admin/company";
    }
    
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(@ModelAttribute(value = "Company")Company company,@Context HttpServletRequest request){
        int companyId=Integer.parseInt(request.getParameter("id"));
        companyService.delete(companyId);
        return "redirect:/admin/company";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute(value = "Company") Company company, @Context HttpServletRequest request) {
        ModelAndView mv = null;
        int id = Integer.parseInt(request.getParameter("id"));
        Company com = companyService.getByCompanyId(id);
        if(com!=null){
          mv   = new ModelAndView("company/edit");
          mv.addObject("company", com);
        }
        return mv;
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "Company") Company company, @Context HttpServletRequest request) {
        company.setCompanyId(Integer.parseInt(request.getParameter("id")));
        companyService.update(company);
        return "redirect:/admin/company";
    }
}
