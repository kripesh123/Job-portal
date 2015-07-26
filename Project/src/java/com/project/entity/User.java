/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;

/**
 *
 * @author Kripesh
 */
public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private int roleId;
    private Role role;

    public User() {
    }

    public User(int userId, String username, String email, String password, int roleId) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", roleId=" + roleId + ", role=" + role + '}';
    }
    

    
    
    
}
