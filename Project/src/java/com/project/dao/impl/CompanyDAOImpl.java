/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao.impl;

import com.project.constants.SQLCommand;
import com.project.dao.CompanyDAO;
import com.project.entity.Company;
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
public class CompanyDAOImpl implements CompanyDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public CompanyDAOImpl(){
        
    }
    @Override
    public int insert(Company c) {
        return jdbcTemplate.update(SQLCommand.COMPANY_INSERT, new Object[]{c.getCompanyName(),c.getCompanyLogo(),c.getCompanyDescription()});
    }

    @Override
    public int update(Company c) {
        return jdbcTemplate.update(SQLCommand.COMPANY_UPDATE,new Object[]{c.getCompanyName(),c.getCompanyLogo(),c.getCompanyDescription(),c.getCompanyId()});
    }

    @Override
    public int delete(int companyId) {
        return jdbcTemplate.update(SQLCommand.COMPANY_DELETE,new Object[]{companyId});
    }

    @Override
    public List<Company> getAll() {
        return jdbcTemplate.query(SQLCommand.COMPANY_GETALL, new RowMapper<Company>() {

            @Override
            public Company mapRow(ResultSet rs, int i) throws SQLException {
                Company company=new Company();
                company.setCompanyId(rs.getInt("company_id"));
                company.setCompanyName(rs.getString("company_name"));
                company.setCompanyDescription(rs.getString("company_description"));
                company.setCompanyLogo(rs.getString("company_logo"));
                
                return company;
            }
        });
    }

    @Override
    public Company getByCompanyId(int companyId) {
    return jdbcTemplate.query(SQLCommand.COMPANY_GETBYCOMPANYID, new Object[]{companyId}, new ResultSetExtractor<Company>() {

            @Override
            public Company extractData(ResultSet rs) throws SQLException, DataAccessException {
                 Company company =null;
                if(rs.next()){
                    company = new Company();
                    company.setCompanyId(rs.getInt("company_id"));
                    company.setCompanyName(rs.getString("company_name"));
                    company.setCompanyDescription(rs.getString("company_description"));
                    company.setCompanyLogo(rs.getString("company_logo")); 
                }
                return company;
            }
        });
    }
}
