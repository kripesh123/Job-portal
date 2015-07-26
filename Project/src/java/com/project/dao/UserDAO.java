/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.entity.User;
import java.util.List;

/**
 *
 * @author Kripesh
 */
public interface UserDAO {
    public int insert(User user);
    public int update(User user);
    public int delete(int userId);
    public List<User>getAll();
    public User getByUserId(int userId);
    public User getByRoleId(int roleId);
    public User authenticate(String username,String password);
    public List<User>getUserWithRole();
}
