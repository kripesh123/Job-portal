/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class AuthInterceptorTest {
    
    public AuthInterceptorTest() {
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
     * Test of preHandle method, of class AuthInterceptor.
     */
    @Test
    public void testPreHandle() throws Exception {
        System.out.println("preHandle");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        Object o = null;
        AuthInterceptor instance = new AuthInterceptor();
        boolean expResult = false;
        boolean result = instance.preHandle(request, response, o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of postHandle method, of class AuthInterceptor.
     
    @Test
    public void testPostHandle() throws Exception {
        System.out.println("postHandle");
        HttpServletRequest hsr = null;
        HttpServletResponse hsr1 = null;
        Object o = null;
        ModelAndView mav = null;
        AuthInterceptor instance = new AuthInterceptor();
        instance.postHandle(hsr, hsr1, o, mav);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afterCompletion method, of class AuthInterceptor.
     
    @Test
    public void testAfterCompletion() throws Exception {
        System.out.println("afterCompletion");
        HttpServletRequest hsr = null;
        HttpServletResponse hsr1 = null;
        Object o = null;
        Exception excptn = null;
        AuthInterceptor instance = new AuthInterceptor();
        instance.afterCompletion(hsr, hsr1, o, excptn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
