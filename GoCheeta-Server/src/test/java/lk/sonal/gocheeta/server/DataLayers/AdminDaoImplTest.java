///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package lk.sonal.gocheeta.server.DataLayers;
//
//import java.util.ArrayList;
//import java.util.List;
//import lk.sonal.gocheeta.server.Models.Admin;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author sonal
// */
//public class AdminDaoImplTest {
//    
//    public AdminDaoImplTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of addAdmin method, of class AdminDaoImpl.
//     */
//    @Test
//    public void testAddAdmin() {
//        System.out.println("addAdmin");
//        Admin amin = new Admin();
//        amin.setId("7");
//        amin.setName("test7");
//        amin.setAddress("address");
//        amin.setAccType("MainAdmin");
//        amin.setBranch("0");
//        amin.setDOB("2002-01-01");
//        amin.setEmail("test@gmail.com");
//        amin.setGender("Male");
//        amin.setPassword("test1234");
//        amin.setUsername("test7");
//        amin.setPhoneNumber("01232343");
//        AdminDao instance = new AdminDaoImpl();
//        boolean expResult = true;
//        boolean result = instance.addAdmin(amin);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       // fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAdmins method, of class AdminDaoImpl.
//     */
////    @Test
////    public void testGetAdmins() {
////        System.out.println("getAdmins");
////        AdminDaoImpl instance = new AdminDaoImpl();
////        List<Admin> expResult = new ArrayList();
////        List<Admin> result = instance.getAdmins();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////       // fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of getFilterAdmins method, of class AdminDaoImpl.
//     */
//    @Test
//    public void testGetFilterAdmins() {
//        System.out.println("getFilterAdmins");
//        String branch = "";
//        String accTYpe = "";
//        String searchText = "";
//        AdminDaoImpl instance = new AdminDaoImpl();
//        List<Admin> expResult = new ArrayList();
//        List<Admin> result = instance.getFilterAdmins(branch, accTYpe, searchText);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       // fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateAdmin method, of class AdminDaoImpl.
//     */
//    @Test
//    public void testUpdateAdmin() {
//        System.out.println("updateAdmin");
//        Admin amin = new Admin();
//        amin.setId("5");
//        amin.setName("test46");
//        amin.setAddress("address");
//        amin.setAccType("MainAdmin");
//        amin.setBranch("0");
//        amin.setDOB("2002-01-01");
//        amin.setEmail("test@gmail.com");
//        amin.setGender("Male");
//        amin.setPassword("test1234");
//        amin.setUsername("test7");
//        amin.setPhoneNumber("01232343");
//        AdminDaoImpl instance = new AdminDaoImpl();
//        boolean expResult = true;
//        boolean result = instance.updateAdmin(amin);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//      //  fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAdmin method, of class AdminDaoImpl.
//     */
//    @Test
//    public void testDeleteAdmin() {
//        System.out.println("deleteAdmin");
//        int id = 4;
//        AdminDaoImpl instance = new AdminDaoImpl();
//        boolean expResult = true;
//        boolean result = instance.deleteAdmin(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//     //   fail("The test case is a prototype.");
//    }
//    
//}
