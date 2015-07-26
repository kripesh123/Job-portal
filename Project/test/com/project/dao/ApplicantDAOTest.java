/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.entity.Applicant;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ApplicantDAOTest {
    
    public ApplicantDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class ApplicantDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Applicant applicant = null;
        ApplicantDAO instance = new ApplicantDAOImpl();
        int expResult = 0;
        int result = instance.insert(applicant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ApplicantDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Applicant applicant = null;
        ApplicantDAO instance = new ApplicantDAOImpl();
        int expResult = 0;
        int result = instance.update(applicant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ApplicantDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int applicantId = 0;
        ApplicantDAO instance = new ApplicantDAOImpl();
        int expResult = 0;
        int result = instance.delete(applicantId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class ApplicantDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ApplicantDAO instance = new ApplicantDAOImpl();
        List<Applicant> expResult = null;
        List<Applicant> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getByApplicantId method, of class ApplicantDAO.
     */
    @Test
    public void testGetByApplicantId() {
        System.out.println("getByApplicantId");
        int applicantId = 0;
        ApplicantDAO instance = new ApplicantDAOImpl();
        Applicant expResult = null;
        Applicant result = instance.getByApplicantId(applicantId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getByJobId method, of class ApplicantDAO.
     */
    @Test
    public void testGetByJobId() {
        System.out.println("getByJobId");
        int jobId = 0;
        ApplicantDAO instance = new ApplicantDAOImpl();
        Applicant expResult = null;
        Applicant result = instance.getByJobId(jobId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApplicantsWithJob method, of class ApplicantDAO.
     */
    @Test
    public void testGetApplicantsWithJob() {
        System.out.println("getApplicantsWithJob");
        String job_id = "";
        ApplicantDAO instance = new ApplicantDAOImpl();
        List<Applicant> expResult = null;
        List<Applicant> result = instance.getApplicantsWithJob(job_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class ApplicantDAOImpl implements ApplicantDAO {

        public int insert(Applicant applicant) {
            return 0;
        }

        public int update(Applicant applicant) {
            return 0;
        }

        public int delete(int applicantId) {
            return 0;
        }

        public List<Applicant> getAll() {
            return null;
        }

        public Applicant getByApplicantId(int applicantId) {
            return null;
        }

        public Applicant getByJobId(int jobId) {
            return null;
        }

        public List<Applicant> getApplicantsWithJob(String job_id) {
            return null;
        }
    }
    
}
