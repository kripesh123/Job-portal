/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao.impl;

import com.project.constants.SQLCommand;
import com.project.dao.RoleDAO;
import com.project.entity.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kripesh
 */
@Repository
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public RoleDAOImpl(){
        
    }
    
    @Override
    public int insert(Role role) {
         return  jdbcTemplate.update(SQLCommand.ROLE_INSERT, new Object[]{role.getRoleName()});
    }

    @Override
    public int update(Role role) {
        return jdbcTemplate.update(SQLCommand.ROLE_UPDATE, new Object[]{role.getRoleName(),role.getRoleId()});
    }

    @Override
    public int delete(int roleId) {
        return jdbcTemplate.update(SQLCommand.ROLE_DELETE, new Object[]{roleId});
    }

    @Override
    public List<Role> getAll() {
        return jdbcTemplate.query(SQLCommand.ROLE_GETALL, new RowMapper<Role>() {

            @Override
            public Role mapRow(ResultSet rs, int i) throws SQLException {
                    Role role=new Role();
                    role.setRoleId(rs.getInt("role_id"));
                    role.setRoleName(rs.getString("role_name"));
                    return role;
            }
        });
    }

    @Override
    public Role getByRoleId(int roleId) {
        return jdbcTemplate.query(SQLCommand.ROLE_GETBYROLEID, new Object[]{roleId}, new ResultSetExtractor<Role>() {

            @Override
            public Role extractData(ResultSet rs) throws SQLException, DataAccessException {
                Role role=null;
                if(rs.next()){
                    role= new Role();
                    role.setRoleId(rs.getInt("role_id"));
                    role.setRoleName(rs.getString("role_name"));
                }
                return role;
            }
        });
    }
    
}
