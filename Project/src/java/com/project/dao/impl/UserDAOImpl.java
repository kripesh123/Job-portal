/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao.impl;

import com.project.constants.SQLCommand;
import com.project.dao.UserDAO;
import com.project.entity.Role;
import com.project.entity.User;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl() {

    }

    @Override
    public int insert(User u) {
        return jdbcTemplate.update(SQLCommand.USER_INSERT, new Object[]{u.getUsername(), u.getEmail(), u.getPassword(), u.getRoleId()});
    }

    @Override
    public int update(User u) {
        return jdbcTemplate.update(SQLCommand.USER_UPDATE, new Object[]{u.getEmail(), u.getUserId()});
    }

    @Override
    public int delete(int userId) {
        return jdbcTemplate.update(SQLCommand.USER_DELETE, new Object[]{userId});
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query(SQLCommand.USER_GETALL, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("role_id"));
                return user;
            }
        });
    }

    @Override
    public User getByUserId(int userId) {
        return jdbcTemplate.query(SQLCommand.USER_GETBYUSERID, new Object[]{userId}, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                User user = null;
                if (rs.next()) {
                    user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setRoleId(rs.getInt("role_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                }
                return user;
            }
        });
    }

    @Override
    public User getByRoleId(int roleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User authenticate(String username, String password) {
        return (User) jdbcTemplate.query(SQLCommand.USER_AUTHENTICATE, new Object[]{username, password, 0}, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                User user = null;

                if (rs.next()) {
                    user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setRoleId(rs.getInt("role_id"));
                }
                return user;
            }
        });
    }

    @Override
    public List<User> getUserWithRole() {
        return jdbcTemplate.query(SQLCommand.USER_ROLE_JOIN, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                //user.setRoleId(rs.getInt("role_id"));
                Role role = new Role();
                role.setRoleName(rs.getString("role_name"));
                user.setRole(role);
                return user;
            }
        });
    }
}
