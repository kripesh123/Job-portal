/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.dao.RoleDAO;
import com.project.dao.impl.RoleDAOImpl;
import com.project.entity.Role;
import com.project.service.RoleService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kripesh
 */
@Controller
@RequestMapping(value = "admin/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
        map.addAttribute("roles", roleService.getAll());
        return "role/index";
    }
    
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public ModelAndView addrole(@ModelAttribute(value = "Role")Role role){  
        ModelAndView mv=new ModelAndView("role/add");
        mv.addObject("role", roleService.getAll());
        return mv;
    }
    
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(@ModelAttribute(value = "Role") Role role){  
        roleService.insert(role);
        return "redirect:/admin/role";
    }
    
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(@ModelAttribute(value = "Role") Role role,@Context HttpServletRequest request){
        int roleId=Integer.parseInt(request.getParameter("id"));
        roleService.delete(roleId);
        return "redirect:/admin/role";
    }
    
    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute(value = "Role")Role role,@Context HttpServletRequest request){
        ModelAndView mv= null;
        int id=Integer.parseInt(request.getParameter("id"));
        Role r=roleService.getByRoleId(id);
        if(r!=null){
            mv= new ModelAndView("role/edit");
            mv.addObject("role", r);
        }
        return mv;
    }
    
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "Role")Role role,@Context HttpServletRequest request){
        role.setRoleId(Integer.parseInt(request.getParameter("id")));
        roleService.update(role);
        return "redirect:/admin/role";
    }
}
