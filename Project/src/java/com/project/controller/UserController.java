/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.dao.RoleDAO;
import com.project.dao.UserDAO;
import com.project.dao.impl.UserDAOImpl;
import com.project.entity.User;
import com.project.service.RoleService;
import com.project.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@RequestMapping(value = "admin/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired 
    private RoleService roleService;
    
   @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
        for(User u: userService.getUserWithRole()){
            System.out.println(u.toString());
        }
        map.addAttribute("users", userService.getUserWithRole());
        return "user/index";
    }
    
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public ModelAndView add(@ModelAttribute(value = "User")User user){
        ModelAndView mv=new ModelAndView("user/add");
        mv.addObject("role", roleService.getAll());
        return mv;
    }
    
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(@ModelAttribute(value = "User")User user){
        userService.insert(user);
        return "redirect:/admin/user";
    }
    
   @RequestMapping(value = "delete",method = RequestMethod.GET)
   public String delete(@ModelAttribute(value = "User")User user,@Context HttpServletRequest request){
       int userId=Integer.parseInt(request.getParameter("id"));
       userService.delete(userId);
       return "redirect:/admin/user";
   }
   
   @RequestMapping(value = "edit",method = RequestMethod.GET)
   public ModelAndView edit(@ModelAttribute(value = "User")User user,@Context HttpServletRequest request){
       ModelAndView mv=null;
       int id=Integer.parseInt(request.getParameter("id"));
       User u=userService.getByUserId(id);
       if(u!=null){
           mv = new ModelAndView("user/edit");
           mv.addObject("role", roleService.getByRoleId(u.getRoleId()));
           mv.addObject("roles", roleService.getAll());
           mv.addObject("user", u);
       }
       return mv;
   }
   
   @RequestMapping(value = "update",method = RequestMethod.POST)
   public String update(@ModelAttribute(value = "User")User user,@Context HttpServletRequest request){
       user.setUserId(Integer.parseInt(request.getParameter("id")));
       userService.update(user);
       return "redirect:/admin/user";
   }
            
}
