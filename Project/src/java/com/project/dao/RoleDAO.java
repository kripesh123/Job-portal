/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.entity.Role;
import java.util.List;

/**
 *
 * @author Kripesh
 */
public interface RoleDAO {
    public int insert (Role role);
    public int update(Role role);
    public int delete(int roleId);
    public List<Role>getAll();
    public Role getByRoleId(int roleId);
    
}
