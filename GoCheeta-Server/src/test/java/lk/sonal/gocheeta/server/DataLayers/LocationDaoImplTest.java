///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package lk.sonal.gocheeta.server.DataLayers;
//
//import java.util.ArrayList;
//import java.util.List;
//import lk.sonal.gocheeta.server.Models.Location;
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
//public class LocationDaoImplTest {
//    
//    public LocationDaoImplTest() {
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
//     * Test of AddLocation method, of class LocationDaoImpl.
//     */
//    @Test
//    public void testAddLocation() {
//        System.out.println("AddLocation");
//        Location location = null;
//        LocationDaoImpl instance = new LocationDaoImpl();
//        boolean expResult = false;
//        boolean result = instance.AddLocation(location);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getLocations method, of class LocationDaoImpl.
//     */
//    @Test
//    public void testGetLocations() {
//        System.out.println("getLocations");
//        LocationDaoImpl instance = new LocationDaoImpl();
//        List<Location> expResult = new ArrayList();
//        List<Location> result = instance.getLocations();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getLocationsNames method, of class LocationDaoImpl.
//     */
//    @Test
//    public void testGetLocationsNames() {
//        System.out.println("getLocationsNames");
//        LocationDaoImpl instance = new LocationDaoImpl();
//        List<Location> expResult = new ArrayList();
//        List<Location> result = instance.getLocationsNames();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRelatedLocations method, of class LocationDaoImpl.
//     */
//    @Test
//    public void testGetRelatedLocations() {
//        System.out.println("getRelatedLocations");
//        String loction = "";
//        LocationDaoImpl instance = new LocationDaoImpl();
//        List<Location> expResult = new ArrayList();
//        List<Location> result = instance.getRelatedLocations(loction);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//    
//}
