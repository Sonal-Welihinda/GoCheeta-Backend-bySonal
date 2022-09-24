/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import lk.sonal.gocheeta.server.Models.Admin;
import lk.sonal.gocheeta.server.Models.Branch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import lk.sonal.gocheeta.server.DataLayers.AdminDao;
import lk.sonal.gocheeta.server.DataLayers.AdminDaoImpl;
import lk.sonal.gocheeta.server.DataLayers.BookingDao;
import lk.sonal.gocheeta.server.DataLayers.BookingDaoImpl;
import lk.sonal.gocheeta.server.DataLayers.BranchDao;
import lk.sonal.gocheeta.server.DataLayers.BranchDaoImpl;
import lk.sonal.gocheeta.server.DataLayers.CustomerDao;
import lk.sonal.gocheeta.server.DataLayers.CustomerDaoImpl;
import lk.sonal.gocheeta.server.DataLayers.DaoFactory;
import lk.sonal.gocheeta.server.DataLayers.DaoInterface;
import lk.sonal.gocheeta.server.DataLayers.DriverDao;
import lk.sonal.gocheeta.server.DataLayers.DriverDaoImpl;
import lk.sonal.gocheeta.server.DataLayers.LocationDao;
import lk.sonal.gocheeta.server.DataLayers.LocationDaoImpl;
import lk.sonal.gocheeta.server.DataLayers.VehicleCategoryDao;
import lk.sonal.gocheeta.server.DataLayers.VehicleCategoryDaoImpl;
import lk.sonal.gocheeta.server.DataLayers.VehicleDao;
import lk.sonal.gocheeta.server.DataLayers.VehicleDaoImpl;
import lk.sonal.gocheeta.server.Models.Booking;
import lk.sonal.gocheeta.server.Models.Customer;
import lk.sonal.gocheeta.server.Models.Driver;
import lk.sonal.gocheeta.server.Models.Location;
import lk.sonal.gocheeta.server.Models.Vehicle;

/**
 *
 * @author sonal
 */
public class BL {
    
    final static BL bl = new BL();
    String ONRIDE = "onRide";
    String Available = "Available";
    
    Gson gson = new GsonBuilder().create();
//    AdminDao AdminDB ;
//    BranchDao BranchDB;
//    VehicleCategoryDao VCategoryDB;
//    VehicleDao VehicleDB;
//    LocationDao LocationDB;
//    CustomerDao customerDB;
//    BookingDao BookingDB;
//    DriverDao DriverDB;
    FileOperation files;
    
    DaoInterface DB_OBJECT;
    

    
    public static BL getInstance(){
        
        return bl;
    }
    
    public BL(){
//        AdminDB = new AdminDaoImpl();
//        BranchDB = new BranchDaoImpl();
//        VCategoryDB = new VehicleCategoryDaoImpl();
//        VehicleDB = new VehicleDaoImpl();
//        DriverDB = new DriverDaoImpl();
//        LocationDB = new LocationDaoImpl();
//        customerDB = new CustomerDaoImpl();
//        BookingDB = new BookingDaoImpl();
        
        DB_OBJECT = DaoFactory.getDatabase("MYSQL");
        
        
        files = new FileOperation ();

        
    }
    
    
//    
//    Branches   --------------
//    
    
    public String getBranches() {
        DBUtill util = new DBUtill();
        return gson.toJson(util.getBranches());
    }
    
    public String addBranch(String json) {
        
        Branch branch = gson.fromJson(json, Branch.class);
        boolean result = DB_OBJECT.addBranch(branch);  
        
        if(result){
            return "Success, Branch Added";
        }else{
            return "Error, Branch Added";
        }
        
    }
    
    public String updateBranch(String json) {
        
        Branch branch = gson.fromJson(json, Branch.class);
        boolean result = DB_OBJECT.updateBranch(branch);    
        if (result) {
            return "Success, Branch Updated";
        } else {
            return "Error, Branch Added";
        }
    }
    
    public String deleteBranch(int id) {
        boolean result = DB_OBJECT.deleteBranch(id);    
        if (result) {
            return "Success, Branch removed";
        } else {
            return "Error,  Error occurred";
        }
    }
    
    
//    
//    Admin ----------------------------------
//    
    
    public String getAdmins() {
        
        return gson.toJson(DB_OBJECT.getAdmins());
    }
    
    public String addAdmin(String json) {
        
        Admin admin = gson.fromJson(json, Admin.class);
        DBUtill util = new DBUtill();
        boolean result = DB_OBJECT.addAdmin(admin);  
        if (result) {
            return "Success, Successfully added";
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String UpdateAdmin(String json) {
        Admin admin = gson.fromJson(json, Admin.class);
        boolean result = DB_OBJECT.updateAdmin(admin);  
        if (result) {
            return "Success, Successfully Updated" ;
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String deleteAdmin(int id) {
       DBUtill util = new DBUtill();
        boolean result = DB_OBJECT.deleteAdmin(id);    
        if (result) {
            return "Success, Admin removed ";
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String getFiltersAdmins(String bID,String AccType , String SearchTxt ) {
        return gson.toJson(DB_OBJECT.getFilterAdmins(bID, AccType, SearchTxt));
    }
    
    public String LoginAdmin(String json){
        Admin admin = gson.fromJson(json, Admin.class);
        
        admin = DB_OBJECT.AdminLogin(admin);
        
        if(admin == null){
            return "Error, No Admin Found";
        }
        
        
        return gson.toJson(admin);
    }
    

//    
//    Vehicle 
//    
//    
//    
    public String addVehicle(String json){
        Vehicle vehicle = gson.fromJson(json, Vehicle.class);
        String filename;
        try {
            filename= files.SaveFile("Vehicle", vehicle.getImageBase64());
        } catch (Exception ex) {
            Logger.getLogger(BL.class.getName()).log(Level.SEVERE, null, ex);
            return "Error,"+ex.getMessage();
        }
        
        vehicle.setImagePath(filename);
        
        if(!DB_OBJECT.addVehicle(vehicle)){
            return "Error, while adding Vehicle";
        }
        
        
        boolean result = DB_OBJECT.AddVehicleAccessibility(vehicle); 
        if (result) {
            return "Success, Successfully added";
        } else {
            return "Error, while Adding Access to Drivers";
        }
    }
    
    public String getVehicles() {
        List<Vehicle> list = DB_OBJECT.getVehicles();
        
        for(Vehicle vehicle : list){
            vehicle.setImageBase64(files.readFile(vehicle.getImagePath()));
            vehicle.setDriverIds(DB_OBJECT.getVehicleAccess(vehicle));
        }
        
        
        
        return gson.toJson(list);
    }
    
    public String UpdateVehicle(String json) throws Exception {
        Vehicle vehicle = gson.fromJson(json, Vehicle.class);
        List<Integer> driverID;
        
        if(!vehicle.getImageBase64().isEmpty()){
            if(!files.deleteFile(vehicle.getImagePath())){
                throw new Exception("Something went wrong");
            }
            vehicle.setImagePath(files.SaveFile("Vehicle", vehicle.getImageBase64()));
            
        }
        
        if(!DB_OBJECT.updateVehicle(vehicle)){
            throw new Exception("Something went while Updateing Vehicle");
        }
        driverID = DB_OBJECT.getVehicleAccess(vehicle);
        
        if(!vehicle.getDriverIds().equals(driverID)){
            
            
            for(int Id : driverID){
                if(!vehicle.getDriverIds().contains(Id)){
                    if(!DB_OBJECT.deleteVehicleAccess(vehicle, Id)){
                        throw new Exception("Something went while removing Vehicle Access");
                    }
                }
            }
            
            for(int Id : vehicle.getDriverIds()){
                if(!driverID.contains(Id)){
                    if(!DB_OBJECT.AddOneVehicleAccessibility(vehicle, Id)){
                        throw new Exception("Something went while Adding Vehicle Access");
                    }
                }
            }

            
        }
       
        boolean result = DB_OBJECT.updateVehicle(vehicle);  
        if (result) {
            return "Success, Successfully Updated" ;
        } else {
            throw new Exception( "Error, Error occurred");
        }
    }
    
//    
//    Vehicle 
//    
//    Categories
//    
    
    
    public String addVCategory(String json) throws Exception {
        VehicleCategory vCategory = gson.fromJson(json, VehicleCategory.class);
        String filename;
        try {
            //            
            // in here base64 image is in the 'ImageFileLocation' 
            filename= files.SaveFile("VehicleCategory", vCategory.getImageFileLocation());
        } catch (Exception ex) {
            Logger.getLogger(BL.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        
        vCategory.setImageFileLocation(filename);
        
        boolean result = DB_OBJECT.addVCategory(vCategory);  
        if (result) {
            return "Success, Successfully added";
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String getVCategories() {
        List<VehicleCategory> list = DB_OBJECT.getCategories();
        
        for(VehicleCategory vCategory : list){
            vCategory.setImageBase64(files.readFile(vCategory.getImageFileLocation()));
         
        }
        
        return gson.toJson(list);
    }
    
    public String updateVCategory(String json){
        VehicleCategory vCategory = gson.fromJson(json, VehicleCategory.class);
        String fileName ="";
        
        try {
            if(vCategory.isImageUpdated()){
                if(!files.deleteFile(vCategory.getImageFileLocation())){
                    return "Error, Unable to delete Image";
                }
                System.out.println(vCategory.getImageBase64());
                fileName = files.SaveFile("VehicleCategory", vCategory.getImageBase64());
                
                vCategory.setImageFileLocation(fileName);

                

            }
            
            if(DB_OBJECT.updateVCategory(vCategory)){
                return "Success, Successfully Updated";
            }
        
        } catch (Exception ex) {
            Logger.getLogger(BL.class.getName()).log(Level.SEVERE, null, ex);
            return "Error, Unable to delete Vehicle category ";
        }
        
        return "Error, Unable to delete Vehicle category ";
    }
    
    
    
//    
//  Driver  
//    
//    
    
    public String addDriver(String json) throws Exception{
        Driver driver = gson.fromJson(json, Driver.class);
        try {
            String fileName = files.SaveFile("Drivers", driver.getImgbase64());
            
            if(fileName == null && fileName.isEmpty()){
                return "Error, Something went wrong while Uploading Image";
            }
            
            driver.setImgLocation(fileName);
            
            boolean result = DB_OBJECT.addDriver(driver); 
            
            
            if (result) {
                return "Success, Successfully added";
            } else {
                return "Error, Something went wrong while addung drivers";
            }
            
        } catch (Exception ex) {
            Logger.getLogger(BL.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }  
    }

    public String getDrivers() {
        List<Driver> list = DB_OBJECT.getDrivers();
        
        for(Driver driver : list){
            driver.setImgbase64(files.readFile(driver.getImgLocation()));
         
        }
        
        return gson.toJson(list);
    }
    
    public String UpdateDriver(String json) {
        Driver driver = gson.fromJson(json, Driver.class);
        
        try {
            if(driver.isImgUpdated()){
                if(!files.deleteFile(driver.getImgLocation())){
                    return "Error, Something went wrong while Uploading Image";
                }
                String fileName = files.SaveFile("Drivers", driver.getImgbase64());
                driver.setImgLocation(fileName);
            }
        } catch (Exception ex) {
            Logger.getLogger(BL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean result = DB_OBJECT.updateDriver(driver);  
        if (result) {
            return "Success, Successfully Updated" ;
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String LoginDriver(String json){
        Driver driver = gson.fromJson(json, Driver.class);
        
        driver = DB_OBJECT.DriverLogin(driver);
        
        if(driver == null){
            return "Error, No Driver Found";
        }
        
        driver.setImgbase64(files.readFile(driver.getImgLocation()));
        
        return gson.toJson(driver);
    }
    
    public String getDriver(String json){
        Driver driver = gson.fromJson(json, Driver.class);
        
        driver = DB_OBJECT.getDriver(driver);
        
        if(driver == null){
            return "Error, No Driver Found";
        }
        
        driver.setImgbase64(files.readFile(driver.getImgLocation()));
        
        return gson.toJson(driver);
    }
    
    public String DriverChangePassoword(String newPass,String json){
        Driver driver = gson.fromJson(json, Driver.class);
        
        driver = DB_OBJECT.DriverLogin(driver);
        
        if(driver == null){
            return "Error, incorrect password";
        }
        
        driver.setPassword(newPass);
        
        if(DB_OBJECT.updateDriver(driver)){
            return "Success, Password Changed" ;
        }else{
            return "Error, Unable to update password";
        }
    }
    
    

//    
//    
//    Locations
//    
//    
    public String addLocation(String json){
        Location location = gson.fromJson(json, Location.class);
        
        if(DB_OBJECT.AddLocation(location)){
            return  "Success, Successfully Updated" ;
        }else{
            return "Error, Error occurred";
        }
        
    }
    
    public String getLocations(){
        return gson.toJson(DB_OBJECT.getLocations());
    }
    
    public String getLocationsNames(){
        return gson.toJson(DB_OBJECT.getLocationsNames());
    }
    
    public String getRelatedLocations(String location){
        return gson.toJson(DB_OBJECT.getRelatedLocations(location));
    }
    
    
    
    
    
//    
//    
//    Customer ------------------------------------------------
//    
//    
    
    public String RegisterCustomer(String json){
        Customer customer = gson.fromJson(json, Customer.class);
        
        if(DB_OBJECT.checkForCustomerAccount(customer)){
            return "Error, There is Already Account with this number";
        }
        
        if(DB_OBJECT.registerCustomer(customer)){
            return  "Success, Successfully Registered";
        }else{
            return "Error, Error occurred";
        }
    }
    
    
    public String CustomerLogin(String json){
        Customer customer = gson.fromJson(json, Customer.class);
        
        customer = DB_OBJECT.LoginCustomer(customer);
        if(customer == null){
            return "error, invalide credentials";
        }
       // String token = JwtToken.createJWT(customer.getCustomerID()+"", "-01", "Customer");
        
        
        return gson.toJson(customer);
    }
    
    public String getCustomerDetails(String token){
//        Jws<Claims> data = JwtToken.parseJwt(token);
//        System.out.println(data);
        
        return token;
    }
    
    
    
//  Booking 


    public String addBooking(String json) {
        Booking booking = gson.fromJson(json, Booking.class);
        
        System.out.println(booking.getVehicle().getDriverIds());
        List<Integer> Drivers = DB_OBJECT.getVehicleAccess(booking.getVehicle());
        
        if(Drivers.size()<0){
            return "Error, No Available Drivers found";
        }
        booking.setDriversId(Drivers.get(0));
        DB_OBJECT.updateDriverStatus(Drivers.get(0), ONRIDE);
        DB_OBJECT.updateVehicleStatus(booking.getVehicle().getPlateNumber(), ONRIDE);
        LocalDateTime date = LocalDateTime.now();
        
        booking.setCreatedDate(date.toString());
        booking.setStatus("Ongoing");
        
        
        if(!DB_OBJECT.AddBookng(booking)){
            return  "Error, Something went wrong while adding the booking";
        }
        
   
        return  "Success, Your Taxi is Booked";
    }
    
    public String getDriversActiveBookings(int i){
//        System.out.println(DB_OBJECT.getDriversActiveBooking(i));
        return gson.toJson(DB_OBJECT.getDriversActiveBooking(i)) ;
    }
    
    public String getAllBookings(){
        List<Booking> list = DB_OBJECT.getAllBookings();
        for(Booking trip :list){
            trip.setVehicle(DB_OBJECT.getVehicle(trip.getVehicleID()));
        }
        return gson.toJson(list);
    }
    
    public String getDriversCompletedBookings(int i){
        return gson.toJson(DB_OBJECT.getDriversCompletedBookings(i)) ;
    }
    
    
    public boolean updateBookingStatus(int i, String status){
        
        return DB_OBJECT.updateBookingStatus(i, status);
    }
    
    public boolean updateBookingRating(String json){
        Booking booking = gson.fromJson(json, Booking.class);
        return DB_OBJECT.updateBookingRating(booking);
    }
    
//    filter Booking Sales
    
    public String getBookingSales(String json){
        List<Booking> list = DB_OBJECT.getBookingSales("", "", "");
        return gson.toJson(list);
    }
    
    
    // Customer booking history
    public String getCustomerBookingHistory(int i){
        
        List<Booking> list = DB_OBJECT.getCustomerBookingHistory(i);
        
        for(Booking trip :list){
            trip.setVehicle(DB_OBJECT.getVehicle(trip.getVehicleID()));
        }
        
        return gson.toJson(list) ;
    }
    
    
    public String getCustomerActiveBookings(int i){
//        System.out.println(DB_OBJECT.getDriversActiveBooking(i));
        return gson.toJson(DB_OBJECT.getCustomerActiveBooking(i)) ;
    }
    
    
}
