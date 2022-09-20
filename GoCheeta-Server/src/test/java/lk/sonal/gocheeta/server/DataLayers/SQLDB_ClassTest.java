///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package lk.sonal.gocheeta.server.DataLayers;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import lk.sonal.gocheeta.server.Models.Admin;
//import lk.sonal.gocheeta.server.Models.Booking;
//import lk.sonal.gocheeta.server.Models.Branch;
//import lk.sonal.gocheeta.server.Models.Customer;
//import lk.sonal.gocheeta.server.Models.Driver;
//import lk.sonal.gocheeta.server.Models.Location;
//import lk.sonal.gocheeta.server.Models.Vehicle;
//import lk.sonal.gocheeta.server.VehicleCategory;
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
//public class SQLDB_ClassTest {
//    
//    public SQLDB_ClassTest() {
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
//     * Test of addAdmin method, of class SQLDB_Class.
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
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.addAdmin(amin);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAdmins method, of class SQLDB_Class.
//     */
////    @Test
////    public void testGetAdmins() {
////        System.out.println("getAdmins");
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Admin> expResult = null;
////        List<Admin> result = instance.getAdmins();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of getFilterAdmins method, of class SQLDB_Class.
//     */
//    @Test
//    public void testGetFilterAdmins() {
//        System.out.println("getFilterAdmins");
//        String branch = "";
//        String accTYpe = "";
//        String searchText = "";
//        SQLDB_Class instance = new SQLDB_Class();
//        List<Admin> expResult =  new ArrayList();
//        List<Admin> result = instance.getFilterAdmins(branch, accTYpe, searchText);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateAdmin method, of class SQLDB_Class.
//     */
//    @Test
//    public void testUpdateAdmin() {
//        System.out.println("updateAdmin");
//        Admin amin = new Admin();
//        amin.setId("6");
//        amin.setName("test46er");
//        amin.setAddress("addgdress");
//        amin.setAccType("MainAdmin");
//        amin.setBranch("0");
//        amin.setEmail("test@gmail.com");
//        amin.setGender("Male");
//        amin.setPassword("test1234");
//        amin.setUsername("test7");
//        amin.setPhoneNumber("01232343");
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = false;
//        boolean result = instance.updateAdmin(amin);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAdmin method, of class SQLDB_Class.
//     */
//    @Test
//    public void testDeleteAdmin() {
//        System.out.println("deleteAdmin");
//        int id = 9;
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.deleteAdmin(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
////    /**
////     * Test of AddBookng method, of class SQLDB_Class.
////     */
////    @Test
////    public void testAddBookng() {
////        System.out.println("AddBookng");
////        Booking booking = null;
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.AddBookng(booking);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getDriversActiveBooking method, of class SQLDB_Class.
////     */
////    @Test
////    public void testGetDriversActiveBooking() {
////        System.out.println("getDriversActiveBooking");
////        int i = 0;
////        SQLDB_Class instance = new SQLDB_Class();
////        Booking expResult = null;
////        Booking result = instance.getDriversActiveBooking(i);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of updateBookingStatus method, of class SQLDB_Class.
////     */
////    @Test
////    public void testUpdateBookingStatus() {
////        System.out.println("updateBookingStatus");
////        int i = 0;
////        String string = "";
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.updateBookingStatus(i, string);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of addBranch method, of class SQLDB_Class.
//     */
//    @Test
//    public void testAddBranch() {
//        System.out.println("addBranch");
//        Branch branch = new Branch();
//        branch.setAddress("523,4 testrd  testcity");
//        branch.setCity("test City");
//        branch.setLatitude(BigDecimal.ONE);
//        branch.setLongitude(BigDecimal.ONE);
//        branch.setName("new test soon will be deleted");
//        branch.setPhoneNumber("0878787");
//        branch.setStatus(false);
//        
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.addBranch(branch);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBranches method, of class SQLDB_Class.
//     */
////    @Test
////    public void testGetBranches() {
////        System.out.println("getBranches");
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Branch> expResult = null;
////        List<Branch> result = instance.getBranches();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of updateBranch method, of class SQLDB_Class.
//     */
//    @Test
//    public void testUpdateBranch() {
//        System.out.println("updateBranch");
//        Branch branch = new Branch();
//        branch.setBranchID(11);
//        branch.setAddress("523,4 testrd  testcity");
//        branch.setCity("test Cy");
//        branch.setLatitude(BigDecimal.ONE);
//        branch.setLongitude(BigDecimal.ONE);
//        branch.setName("old test soon ll be deleted");
//        branch.setPhoneNumber("0878787");
//        branch.setStatus(false);
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.updateBranch(branch);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteBranch method, of class SQLDB_Class.
//     */
//    @Test
//    public void testDeleteBranch() {
//        System.out.println("deleteBranch");
//        int id = 10;
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.deleteBranch(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registerCustomer method, of class SQLDB_Class.
//     */
//    @Test
//    public void testRegisterCustomer() {
//        System.out.println("registerCustomer");
//        Customer co = new Customer();
//        co.setAddress("test address");
//        co.setCustomerID(4);
//        co.setEmail("testEmail");
//        co.setGender("male");
//        co.setName("test");
//        co.setPassword("password");
//        co.setPhoneNumber("0645645");
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.registerCustomer(co);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkForCustomerAccount method, of class SQLDB_Class.
//     */
//    @Test
//    public void testCheckForCustomerAccount() {
//        System.out.println("checkForCustomerAccount");
//        Customer co = new Customer();
//        co.setPhoneNumber("+94768527431");
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.checkForCustomerAccount(co);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of LoginCustomer method, of class SQLDB_Class.
//     */
//    @Test
//    public void testLoginCustomer() {
//        System.out.println("LoginCustomer");
//        Customer co = new Customer();
//        co.setPhoneNumber("+94768527431");
//        co.setPassword("test1234");
//        SQLDB_Class instance = new SQLDB_Class();
//        Customer expResult = co;
//        Customer result = instance.LoginCustomer(co);
//        assertEquals(expResult.getPhoneNumber(), result.getPhoneNumber());
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCustomer method, of class SQLDB_Class.
//     */
////    @Test
////    public void testGetCustomer() {
////        System.out.println("getCustomer");
////        int customerID = 0;
////        SQLDB_Class instance = new SQLDB_Class();
////        Customer expResult = null;
////        Customer result = instance.getCustomer(customerID);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of addDriver method, of class SQLDB_Class.
//     */
////    @Test
////    public void testAddDriver() throws Exception {
////        System.out.println("addDriver");
////        Driver driver = null;
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.addDriver(driver);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getDrivers method, of class SQLDB_Class.
////     */
////    @Test
////    public void testGetDrivers() {
////        System.out.println("getDrivers");
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Driver> expResult = null;
////        List<Driver> result = instance.getDrivers();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of updateDriver method, of class SQLDB_Class.
////     */
////    @Test
////    public void testUpdateDriver() {
////        System.out.println("updateDriver");
////        Driver driver = null;
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.updateDriver(driver);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of updateDriverStatus method, of class SQLDB_Class.
////     */
////    @Test
////    public void testUpdateDriverStatus() {
////        System.out.println("updateDriverStatus");
////        int i = 0;
////        String status = "";
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.updateDriverStatus(i, status);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of DriverLogin method, of class SQLDB_Class.
////     */
////    @Test
////    public void testDriverLogin() {
////        System.out.println("DriverLogin");
////        Driver driver = null;
////        SQLDB_Class instance = new SQLDB_Class();
////        Driver expResult = null;
////        Driver result = instance.DriverLogin(driver);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
//
////    /**
////     * Test of AddLocation method, of class SQLDB_Class.
////     */
////    @Test
////    public void testAddLocation() {
////        System.out.println("AddLocation");
////        Location location = null;
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.AddLocation(location);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getLocations method, of class SQLDB_Class.
////     */
////    @Test
////    public void testGetLocations() {
////        System.out.println("getLocations");
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Location> expResult = null;
////        List<Location> result = instance.getLocations();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getLocationsNames method, of class SQLDB_Class.
////     */
////    @Test
////    public void testGetLocationsNames() {
////        System.out.println("getLocationsNames");
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Location> expResult = null;
////        List<Location> result = instance.getLocationsNames();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getRelatedLocations method, of class SQLDB_Class.
////     */
////    @Test
////    public void testGetRelatedLocations() {
////        System.out.println("getRelatedLocations");
////        String loction = "";
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Location> expResult = null;
////        List<Location> result = instance.getRelatedLocations(loction);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of addVCategory method, of class SQLDB_Class.
//     */
//    @Test
//    public void testAddVCategory() {
//        System.out.println("addVCategory");
//        VehicleCategory v = new VehicleCategory();
//        v.setCategoryID(12);
//        v.setCategoryName("testCat");
//        v.setImageUpdated(false);
//        v.setImageFileLocation("VehicleCateogry/test.jpg");
//        
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.addVCategory(v);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCategories method, of class SQLDB_Class.
//     */
////    @Test
////    public void testGetCategories() {
////        System.out.println("getCategories");
////        SQLDB_Class instance = new SQLDB_Class();
////        List<VehicleCategory> expResult = null;
////        List<VehicleCategory> result = instance.getCategories();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of updateVCategory method, of class SQLDB_Class.
//     */
//    @Test
//    public void testUpdateVCategory() {
//        System.out.println("updateVCategory");
//        VehicleCategory v = new VehicleCategory();
//        v.setCategoryID(13);
//        v.setCategoryName("testCategory");
//        v.setImageUpdated(false);
//        v.setImageFileLocation("VehicleCateogry/test.jpg");
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.updateVCategory(v);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addVehicle method, of class SQLDB_Class.
//     */
//    @Test
//    public void testAddVehicle() {
//        System.out.println("addVehicle");
//        Vehicle vehicle = new Vehicle();
//        vehicle.setBaseFare(BigDecimal.ZERO);
//        vehicle.setBranchID(5);
//        vehicle.setCategoryID(11);
//        vehicle.setImagePath("test/test.jpg");
//        vehicle.setName("test vehicle");
//        vehicle.setPlateNumber("tt-tttt4");
//        vehicle.setSeat(5);
//        vehicle.setStatus("Availble");
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.addVehicle(vehicle);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateVehicle method, of class SQLDB_Class.
//     */
//    @Test
//    public void testUpdateVehicle() {
//        System.out.println("updateVehicle");
//        Vehicle vehicle = new Vehicle();
//        vehicle.setBaseFare(BigDecimal.ZERO);
//        vehicle.setBranchID(5);
//        vehicle.setCategoryID(11);
//        vehicle.setImagePath("test/newtest.jpg");
//        vehicle.setName("test vehicle");
//        vehicle.setPlateNumber("gg-5555");
//        vehicle.setSeat(5);
//        vehicle.setStatus("Availble");
//        SQLDB_Class instance = new SQLDB_Class();
//        boolean expResult = true;
//        boolean result = instance.updateVehicle(vehicle);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of AddVehicleAccessibility method, of class SQLDB_Class.
//     */
////    @Test
////    public void testAddVehicleAccessibility() {
////        System.out.println("AddVehicleAccessibility");
////        Vehicle vehicle = null;
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.AddVehicleAccessibility(vehicle);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getVehicles method, of class SQLDB_Class.
////     */
////    @Test
////    public void testGetVehicles() {
////        System.out.println("getVehicles");
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Vehicle> expResult = null;
////        List<Vehicle> result = instance.getVehicles();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getVehicleAccess method, of class SQLDB_Class.
////     */
////    @Test
////    public void testGetVehicleAccess() {
////        System.out.println("getVehicleAccess");
////        Vehicle vhcl = null;
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Integer> expResult = null;
////        List<Integer> result = instance.getVehicleAccess(vhcl);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of deleteVehicleAccess method, of class SQLDB_Class.
////     */
////    @Test
////    public void testDeleteVehicleAccess() {
////        System.out.println("deleteVehicleAccess");
////        Vehicle vhcl = null;
////        int DriverID = 0;
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.deleteVehicleAccess(vhcl, DriverID);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of AddOneVehicleAccessibility method, of class SQLDB_Class.
////     */
////    @Test
////    public void testAddOneVehicleAccessibility() {
////        System.out.println("AddOneVehicleAccessibility");
////        Vehicle vehicle = null;
////        int i = 0;
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.AddOneVehicleAccessibility(vehicle, i);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of updateVehicleStatus method, of class SQLDB_Class.
////     */
////    @Test
////    public void testUpdateVehicleStatus() {
////        System.out.println("updateVehicleStatus");
////        String numberPlate = "";
////        String status = "";
////        SQLDB_Class instance = new SQLDB_Class();
////        boolean expResult = false;
////        boolean result = instance.updateVehicleStatus(numberPlate, status);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getVehicleAccessAvailable method, of class SQLDB_Class.
////     */
////    @Test
////    public void testGetVehicleAccessAvailable() {
////        System.out.println("getVehicleAccessAvailable");
////        Vehicle vhcl = null;
////        SQLDB_Class instance = new SQLDB_Class();
////        List<Integer> expResult = null;
////        List<Integer> result = instance.getVehicleAccessAvailable(vhcl);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        //fail("The test case is a prototype.");
////    }
//    
//}
