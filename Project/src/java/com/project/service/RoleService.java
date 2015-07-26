/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.dao.RoleDAO;
import com.project.entity.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service 
public class RoleService {
    @Autowired
    private RoleDAO rdao;
    
    public int insert(Role role){
        return rdao.insert(role);
    }
    public int update(Role role){
        return rdao.update(role);
    }
    public int delete(int roleId){
        return rdao.delete(roleId);
    }
    public List<Role>getAll(){
        return rdao.getAll();
    }
    public Role getByRoleId(int roleId){
        return rdao.getByRoleId(roleId);
    }
}
