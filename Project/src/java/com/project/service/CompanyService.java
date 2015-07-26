/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.dao.CompanyDAO;
import com.project.entity.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service 
public class CompanyService {
    @Autowired
    private CompanyDAO cdao;
    
    public int insert(Company company){
        return cdao.insert(company);
    }
    public int update(Company company){
        return cdao.update(company);
    }
    public int delete(int companyId){
        return cdao.delete(companyId);
    }
    public List<Company>getAll(){
        return cdao.getAll();
    }
    public Company getByCompanyId(int companyId){
        return cdao.getByCompanyId(companyId);
    }
}
