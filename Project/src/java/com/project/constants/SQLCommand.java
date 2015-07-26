/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.constants;

/**
 *
 * @author Kripesh
 */
public class SQLCommand {

    //applicant

    public static final String APPLICANT_INSERT = "INSERT INTO " + Table.TABLE_APPLICANT + " (job_id,first_name,last_name,email,contact_no,cover_letter,resume,apply_date,application_status,remarks) VALUES(?,?,?,?,?,?,?,?,?,?)";
    public static final String APPLICANT_UPDATE = "UPDATE " + Table.TABLE_APPLICANT + " SET application_status=?,remarks=?,edit_date=? WHERE applicant_id=?";
    public static final String APPLICANT_DELETE = "UPDATE " + Table.TABLE_APPLICANT + " SET delete_flag=1 WHERE applicant_id=? ";
    public static final String APPLICANT_GETALL = "SELECT * FROM " + Table.TABLE_APPLICANT + " WHERE delete_flag=0";
    public static final String APPLICANT_GETBYAPPLICANTID = "SELECT * FROM " + Table.TABLE_APPLICANT + " WHERE applicant_id=?";
    public static final String APPLICANT_GETBYJOBID = "SELECT * FROM  " + Table.TABLE_APPLICANT + " WHERE job_id=?";
    public static final String APPLICANT_JOB_JOIN = "SELECT * FROM  " + Table.TABLE_APPLICANT + " applicants join " + Table.TABLE_JOB + " jobs on applicants.job_id=jobs.job_id WHERE applicants.delete_flag = 0";
   
    //company
    public static final String COMPANY_INSERT = "INSERT INTO " + Table.TABLE_COMPANY + " (company_name,company_logo,company_description) VALUES(?,?,?)";
    public static final String COMPANY_UPDATE = "UPDATE " + Table.TABLE_COMPANY + " SET company_name=?,company_logo=?,company_description=? WHERE company_id=?";
    public static final String COMPANY_DELETE = "UPDATE " + Table.TABLE_COMPANY + " SET delete_flag=1 WHERE company_id=?";
    public static final String COMPANY_GETALL = "SELECT * FROM " + Table.TABLE_COMPANY + " WHERE delete_flag=0";
    public static final String COMPANY_GETBYCOMPANYID = "SELECT * FROM  " + Table.TABLE_COMPANY + " WHERE company_id=?";

    //job
    public static final String JOB_INSERT = "INSERT INTO " + Table.TABLE_JOB + " (company_id,job_title,job_description,posted_date,posting_close_date,status) VALUES(?,?,?,?,?,?)";
    public static final String JOB_UPDATE = "UPDATE " + Table.TABLE_JOB + " SET company_id=?,job_title=?,job_description=?,posting_close_date=?,status=? WHERE job_id=?";
    public static final String JOB_DELETE = "UPDATE " + Table.TABLE_JOB + " SET delete_flag=1 WHERE job_id=?";
    public static final String JOB_GETALL = "SELECT * FROM " + Table.TABLE_JOB + " WHERE delete_flag=0";
    public static final String JOB_GETBYJOBID = "SELECT * FROM " + Table.TABLE_JOB + " WHERE job_id=?";
    public static final String JOB_GETBYCOMPANYID = "SELECT * FROM " + Table.TABLE_JOB + " WHERE company_id=?";
    public static final String JOB_COMPANY_JOIN="SELECT * FROM "+Table.TABLE_JOB+" jobs join "+Table.TABLE_COMPANY+" companies on jobs.company_id=companies.company_id";
    public static final String JOB_WITHAPPLICANTS = "select * from tbl_jobs jobs LEFT JOIN (select job_id,count(1) as total_applicants from tbl_applicants group by job_id) applicants on jobs.job_id=applicants.job_id JOIN tbl_companies company on jobs.company_id=company.company_id WHERE jobs.delete_flag = 0";

    //role
    public static final String ROLE_INSERT = "INSERT INTO "+Table.TABLE_ROLE+" (role_name) VALUES(?)";
    public static final String ROLE_UPDATE = "UPDATE "+Table.TABLE_ROLE+" SET role_name=? WHERE role_id=?";
    public static final String ROLE_DELETE = "UPDATE " + Table.TABLE_ROLE + " SET delete_flag=1 WHERE role_id=?";
    public static final String ROLE_GETALL = "SELECT * FROM " + Table.TABLE_ROLE + " WHERE delete_flag=0";
    public static final String ROLE_GETBYROLEID= "SELECT * FROM " + Table.TABLE_ROLE + " WHERE role_id=?";

    //schedule
    public static final String SCHEDULE_INSERT="INSERT INTO "+Table.TABLE_INTERVIEW_SCHEDULE+" (applicant_id,schedule_date,schedule_time,interviewer,message_for_applicant,message_for_interviewer,schedule_status,remarks) VALUES(?,?,?,?,?,?,?,?)";
    public static final String SCHEDULE_UPDATE="UPDATE "+Table.TABLE_INTERVIEW_SCHEDULE+" SET applicant_id=?,schedule_date=?,schedule_time=?,interviewer=?,edit_date=?,message_for_applicant=?,message_for_interviewer=?,schedule_status=?,remarks=? WHERE schedule_id=?";
    public static final String SCHEDULE_DELETE="UPDATE " + Table.TABLE_INTERVIEW_SCHEDULE + " SET delete_flag=1 WHERE schedule_id=?";
    public static final String SCHEDULE_GETALL="SELECT * FROM " + Table.TABLE_INTERVIEW_SCHEDULE + " WHERE delete_flag=0";
    public static final String SCHEDULE_GETBYSCHEDULEID="SELECT * FROM " + Table.TABLE_INTERVIEW_SCHEDULE+ " WHERE schedule_id=?";
    public static final String SCHEDULE_GETBYAPPLICANTID="SELECT * FROM " + Table.TABLE_INTERVIEW_SCHEDULE+ " WHERE applicant_id=?";
    public static final String SCHEDULE_GETBYROLEID="SELECT * FROM " + Table.TABLE_INTERVIEW_SCHEDULE+ " WHERE role_id=?";
    public static final String SCHEDULE_APPLICANT_ROLE_JOIN="SELECT * FROM "+Table.TABLE_INTERVIEW_SCHEDULE+" schedules join "+Table.TABLE_APPLICANT+" applicants on schedules.applicant_id=applicants.applicant_id JOIN "+Table.TABLE_ROLE+" roles on schedules.interviewer= roles.role_id WHERE schedules.delete_flag = 0";
    

    //user
    public static final String USER_INSERT="INSERT INTO "+Table.TABLE_USER+" (username,email,password,role_id) VALUES(?,?,?,?)";
    public static final String USER_UPDATE="UPDATE "+Table.TABLE_USER+" SET email=?WHERE user_id=?";
    public static final String USER_DELETE="UPDATE "+Table.TABLE_USER+" SET delete_flag=1 WHERE user_id=?";
    public static final String USER_GETALL="SELECT * FROM "+Table.TABLE_USER+" WHERE delete_flag=0";
    public static final String USER_GETBYUSERID="SELECT * FROM "+Table.TABLE_USER+" WHERE user_id=?";
    public static final String USER_GETBYROLEID="SELECT * FROM "+Table.TABLE_USER+" WHERE role_id=?";
    public static final String USER_AUTHENTICATE= "SELECT * FROM "+Table.TABLE_USER+" WHERE username=? AND password=? AND delete_flag = ?";
    public static final String USER_ROLE_JOIN = "SELECT * FROM  " + Table.TABLE_USER + " users join " + Table.TABLE_ROLE + "  roles on users.role_id=roles.role_id WHERE users.delete_flag = 0";    
}
