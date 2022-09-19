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
    AdminDao AdminDB ;
    BranchDao BranchDB;
    VehicleCategoryDao VCategoryDB;
    VehicleDao VehicleDB;
    LocationDao LocationDB;
    CustomerDao customerDB;
    BookingDao BookingDB;
    DriverDao DriverDB;
    FileOperation files;
    

    
    public static BL getInstance(){
        
        return bl;
    }
    
    public BL(){
        AdminDB = new AdminDaoImpl();
        BranchDB = new BranchDaoImpl();
        VCategoryDB = new VehicleCategoryDaoImpl();
        VehicleDB = new VehicleDaoImpl();
        DriverDB = new DriverDaoImpl();
        LocationDB = new LocationDaoImpl();
        customerDB = new CustomerDaoImpl();
        BookingDB = new BookingDaoImpl();
        
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
        boolean result = BranchDB.addBranch(branch);  
        
        if(result){
            return "Success, Branch Added";
        }else{
            return "Error, Branch Added";
        }
        
    }
    
    public String updateBranch(String json) {
        
        Branch branch = gson.fromJson(json, Branch.class);
        boolean result = BranchDB.updateBranch(branch);    
        if (result) {
            return "Success, Branch Updated";
        } else {
            return "Error, Branch Added";
        }
    }
    
    public String deleteBranch(int id) {
        boolean result = BranchDB.deleteBranch(id);    
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
        
        return gson.toJson(AdminDB.getAdmins());
    }
    
    public String addAdmin(String json) {
        
        Admin admin = gson.fromJson(json, Admin.class);
        DBUtill util = new DBUtill();
        boolean result = AdminDB.addAdmin(admin);  
        if (result) {
            return "Success, Successfully added";
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String UpdateAdmin(String json) {
        Admin admin = gson.fromJson(json, Admin.class);
        boolean result = AdminDB.updateAdmin(admin);  
        if (result) {
            return "Success, Successfully Updated" ;
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String deleteAdmin(int id) {
       DBUtill util = new DBUtill();
        boolean result = AdminDB.deleteAdmin(id);    
        if (result) {
            return "Success, Admin removed ";
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String getFiltersAdmins(String bID,String AccType , String SearchTxt ) {
        return gson.toJson(AdminDB.getFilterAdmins(bID, AccType, SearchTxt));
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
        
        if(!VehicleDB.addVehicle(vehicle)){
            return "Error, while adding Vehicle";
        }
        
        
        boolean result = VehicleDB.AddVehicleAccessibility(vehicle); 
        if (result) {
            return "Success, Successfully added";
        } else {
            return "Error, while Adding Access to Drivers";
        }
    }
    
    public String getVehicles() {
        List<Vehicle> list = VehicleDB.getVehicles();
        
        for(Vehicle vehicle : list){
            vehicle.setImageBase64(files.readFile(vehicle.getImagePath()));
            vehicle.setDriverIds(VehicleDB.getVehicleAccess(vehicle));
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
        
        if(!VehicleDB.updateVehicle(vehicle)){
            throw new Exception("Something went while Updateing Vehicle");
        }
        driverID = VehicleDB.getVehicleAccess(vehicle);
        
        if(!vehicle.getDriverIds().equals(driverID)){
            
            
            for(int Id : driverID){
                if(!vehicle.getDriverIds().contains(Id)){
                    if(!VehicleDB.deleteVehicleAccess(vehicle, Id)){
                        throw new Exception("Something went while removing Vehicle Access");
                    }
                }
            }
            
            for(int Id : vehicle.getDriverIds()){
                if(!driverID.contains(Id)){
                    if(!VehicleDB.AddOneVehicleAccessibility(vehicle, Id)){
                        throw new Exception("Something went while Adding Vehicle Access");
                    }
                }
            }

            
        }
       
        boolean result = VehicleDB.updateVehicle(vehicle);  
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
        
        boolean result = VCategoryDB.addVCategory(vCategory);  
        if (result) {
            return "Success, Successfully added";
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String getVCategories() {
        List<VehicleCategory> list = VCategoryDB.getCategories();
        
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
            
            if(VCategoryDB.updateVCategory(vCategory)){
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
            
            boolean result = DriverDB.addDriver(driver); 
            
            
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
        List<Driver> list = DriverDB.getDrivers();
        
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
        
        boolean result = DriverDB.updateDriver(driver);  
        if (result) {
            return "Success, Successfully Updated" ;
        } else {
            return "Error, Error occurred";
        }
    }
    
    public String LoginDriver(String json){
        Driver driver = gson.fromJson(json, Driver.class);
        
        driver = DriverDB.DriverLogin(driver);
        
        if(driver == null){
            return "Error, No Driver Found";
        }
        
        driver.setImgbase64(files.readFile(driver.getImgLocation()));
        
        return gson.toJson(driver);
    }

//    
//    
//    Locations
//    
//    
    public String addLocation(String json){
        Location location = gson.fromJson(json, Location.class);
        
        if(LocationDB.AddLocation(location)){
            return  "Success, Successfully Updated" ;
        }else{
            return "Error, Error occurred";
        }
        
    }
    
    public String getLocations(){
        return gson.toJson(LocationDB.getLocations());
    }
    
    public String getLocationsNames(){
        return gson.toJson(LocationDB.getLocationsNames());
    }
    
    public String getRelatedLocations(String location){
        return gson.toJson(LocationDB.getRelatedLocations(location));
    }
    
    
    
    
    
//    
//    
//    Customer ------------------------------------------------
//    
//    
    
    public String RegisterCustomer(String json){
        Customer customer = gson.fromJson(json, Customer.class);
        
        if(customerDB.checkForCustomerAccount(customer)){
            return "Error, There is Already Account with this number";
        }
        
        if(customerDB.registerCustomer(customer)){
            return  "Success, Successfully Registered";
        }else{
            return "Error, Error occurred";
        }
    }
    
    
    public String CustomerLogin(String json){
        Customer customer = gson.fromJson(json, Customer.class);
        
        customer = customerDB.LoginCustomer(customer);
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
        List<Integer> Drivers = VehicleDB.getVehicleAccess(booking.getVehicle());
        
        if(Drivers.size()<0){
            return "Error, No Available Drivers found";
        }
        booking.setDriversId(Drivers.get(0));
        DriverDB.updateDriverStatus(Drivers.get(0), ONRIDE);
        VehicleDB.updateVehicleStatus(booking.getVehicle().getPlateNumber(), ONRIDE);
        LocalDateTime date = LocalDateTime.now();
        
        booking.setCreatedDate(date.toString());
        booking.setStatus("Ongoing");
        
        
        if(!BookingDB.AddBookng(booking)){
            return  "Error, Something went wrong while adding the booking";
        }
        
   
        return  "Success, Your Taxi is Booked";
    }
    
    public String getDriversActiveBookings(int i){
        return gson.toJson(BookingDB.getDriversActiveBooking(i)) ;
    }
    
    
    public boolean updateBookingStatus(int i, String status){
        
        return BookingDB.updateBookingStatus(i, status);
    }
    
    
}
