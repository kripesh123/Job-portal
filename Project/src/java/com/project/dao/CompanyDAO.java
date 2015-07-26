/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.entity.Company;
import java.util.List;

/**
 *
 * @author Kripesh
 */
public interface CompanyDAO {
    public int insert(Company company);
    public int update(Company company);
    public int delete(int companyId);
    public List<Company>getAll();
    public Company getByCompanyId(int companyId);
    
    
}
