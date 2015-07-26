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
public class Company {
    private int companyId;
    private String companyName;
    private String companyLogo;
    private String companyDescription;
    

    public Company() {
    }

    public Company(int companyId, String companyName, String companyLogo, String companyDescription) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.companyDescription = companyDescription;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", companyName=" + companyName + ", companyLogo=" + companyLogo + ", companyDescription=" + companyDescription + '}';
    }
    
    
}
