/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.sonal.gocheeta.server.Models.Admin;
import lk.sonal.gocheeta.server.Models.Booking;
import lk.sonal.gocheeta.server.Models.Branch;
import lk.sonal.gocheeta.server.Models.Customer;
import lk.sonal.gocheeta.server.Models.Driver;
import lk.sonal.gocheeta.server.Models.Location;
import lk.sonal.gocheeta.server.Models.Vehicle;
import lk.sonal.gocheeta.server.MySqlUtill;
import lk.sonal.gocheeta.server.VehicleCategory;

/**
 *
 * @author sonal
 */
public class SQLDB_Class implements DaoInterface{
    
    Connection conn;
    
    public SQLDB_Class(){
        conn = MySqlUtill.getInstance();
    }
    
    
    

    @Override
    public boolean addAdmin(Admin amin) {
        
        int rowsAffected = 0;
        try {
            
            Statement statement = conn.createStatement();
            rowsAffected = statement.executeUpdate("INSERT INTO `admin_tbl` (`Name`, `Email`, `PhoneNumber`, `Address`, `DOB`, `AccType`, `BranchID`, `Gender`, `Username`, `Password`) VALUES ('"+amin.getName()+"', '"+amin.getEmail()+"', '"+amin.getPhoneNumber()+"', '"+amin.getAddress()+"', '"+amin.getDOB()+"', '"+amin.getAccType()+"', '"+amin.getBranch()+"', '"+amin.getGender()+"', '"+amin.getUsername()+"', '"+amin.getPassword()+"');");
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
        
    }

    @Override
    public List<Admin> getAdmins() {
        List<Admin> admins = new ArrayList<>();
        try {             

           
           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `admin_tbl`");
           while(resultSet.next()) {
               Admin admin = new Admin();

               admin.setId(resultSet.getString("PK_AdminID"));
               admin.setName(resultSet.getString("Name"));
               admin.setEmail(resultSet.getString("Email"));
               admin.setPhoneNumber(resultSet.getString("PhoneNumber"));
               admin.setAddress(resultSet.getString("Address"));
               admin.setDOB(resultSet.getString("DOB"));
               admin.setAccType(resultSet.getString("AccType"));
               admin.setBranch(resultSet.getString("BranchID"));
               admin.setGender(resultSet.getString("Gender"));
               admin.setUsername(resultSet.getString("Username"));
               admin.setPassword("");

               admins.add(admin);
           }
       } catch(Exception e) {
           System.out.println(e);
       }
       return admins;
    }

    @Override
    public List<Admin> getFilterAdmins(String branch, String accTYpe, String searchText) {
        boolean MultipleFilters = false;
        List<Admin> admins = new ArrayList<>();
         try {             
            
            
            String query = "SELECT * FROM `admin_tbl` WHERE ";
            
            if(!branch.trim().isEmpty()){
                query += "BranchID ="+branch;
                MultipleFilters = true;
            }
            
            if(!accTYpe.trim().isEmpty()){
                if(MultipleFilters){
                   query += " AND "; 
                }
                query += "AccType='"+accTYpe+"'";
                MultipleFilters = true;
            }
            
            if(!searchText.trim().isEmpty()){
                if(MultipleFilters){
                   query += " AND "; 
                }
                
                query += "(PK_AdminID LIKE ? OR Name LIKE ? OR Email LIKE ? OR PhoneNumber LIKE ? OR Address LIKE ? OR DOB LIKE ? OR Gender LIKE ? OR Username LIKE ?)";
                MultipleFilters = true;
                
            }
            
            PreparedStatement pat =conn.prepareStatement(query);
            if(!searchText.trim().isEmpty()){
                pat.setString(1, "%"+searchText+"%");
                pat.setString(2, "%"+searchText+"%");
                pat.setString(3, "%"+searchText+"%");
                pat.setString(4, "%"+searchText+"%");
                pat.setString(5, "%"+searchText+"%");
                pat.setString(6, "%"+searchText+"%");
                pat.setString(7, "%"+searchText+"%");
                pat.setString(8, "%"+searchText+"%");   
            }
            
            ResultSet resultSet = pat.executeQuery();
            while(resultSet.next()) {
                Admin admin = new Admin();
                
                admin.setId(resultSet.getString("PK_AdminID"));
                admin.setName(resultSet.getString("Name"));
                admin.setEmail(resultSet.getString("Email"));
                admin.setPhoneNumber(resultSet.getString("PhoneNumber"));
                admin.setAddress(resultSet.getString("Address"));
                admin.setDOB(resultSet.getString("DOB"));
                admin.setAccType(resultSet.getString("AccType"));
                admin.setBranch(resultSet.getString("BranchID"));
                admin.setGender(resultSet.getString("Gender"));
                admin.setUsername(resultSet.getString("Username"));
                admin.setPassword("");
                
                admins.add(admin);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return admins;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        int rowsAffected = 0;
        try {

            Statement statement = conn.createStatement();
            
            
            String query = "UPDATE `admin_tbl` SET `Name` = '"+admin.getName()+"', `Email` = '"+admin.getEmail()+"', `PhoneNumber` = '"+admin.getPhoneNumber()+"', `Address` = '"+admin.getAddress()+"', `DOB` = '"+admin.getDOB()+"', `AccType` ='"+admin.getAccType()+"',`BranchID` ="+  admin.getBranch() +",`Username` = '"+admin.getUsername()+"' ";
            if(!admin.getPassword().trim().isEmpty()){
                query += ", `Password` = '"+admin.getPassword()+"' ";
            }
            query += "WHERE `PK_AdminID` = "+admin.getId()+"";
            
            
            System.out.println(query);
            rowsAffected = statement.executeUpdate(query);
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean deleteAdmin(int id) {
        int rowsAffected = 0;
        try {
            Statement statement = conn.createStatement();
            rowsAffected = statement.executeUpdate("DELETE FROM `admin_tbl` WHERE `PK_AdminID` = '" + id + "'");
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    }

    
    
    
    
    
    
    @Override
    public boolean AddBookng(Booking booking) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `booking_tbl` (`CreatedDate`, `BookingTime`, `CustormerID`, `DriverID`, `VehicleID`, `CustormerName`, `sourceLocation`, `Destination`, `Price`, `Status`, `Distance`) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            pat.setString(1, booking.getCreatedDate());
            pat.setString(2, booking.getBookingTime());
            pat.setInt(3, booking.getCustormerId());
            pat.setInt(4, booking.getDriversId());
            pat.setString(5, booking.getVehicle().getPlateNumber());
            pat.setString(6, booking.getCustomerName());
            pat.setString(7, booking.getSource());
            pat.setString(8, booking.getDestination());
            pat.setBigDecimal(9, booking.getPrice());
            pat.setString(10, booking.getStatus());
            pat.setBigDecimal(11, booking.getDistance());
            
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    }

    @Override
    public Booking getDriversActiveBooking(int i) {
        
        Booking booking = null;
        try{
            PreparedStatement pat = conn.prepareStatement("Select booking_tbl.* from  booking_tbl WHERE DriverID=? AND Status='Ongoing'");
            pat.setInt(1, i);
            
            ResultSet resultSet = pat.executeQuery();
            
            if(resultSet.next()) {
               booking = new Booking();
               booking.setBookingID(resultSet.getInt("PK_BookingID"));
               booking.setCreatedDate(resultSet.getString("CreatedDate"));
               booking.setBookingTime(resultSet.getString("BookingTime"));
               booking.setCustormerId(resultSet.getInt("CustormerID"));
               booking.setDriversId(resultSet.getInt("DriverID"));
               booking.setVehicleID(resultSet.getString("VehicleID"));
               booking.setCustomerName(resultSet.getString("CustormerName"));
               booking.setSource(resultSet.getString("sourceLocation"));
               booking.setDestination(resultSet.getString("Destination"));
               booking.setPrice(resultSet.getBigDecimal("Price"));
               booking.setStatus(resultSet.getString("Status"));
               booking.setDistance(resultSet.getBigDecimal("Distance"));
               booking.setCustomerPhoneNumber(resultSet.getString("PhoneNumber"));
               

           }
            
            
        } catch(Exception e){
        
        
        }
        return booking;
    }

    @Override
    public boolean updateBookingStatus(int i, String string) {
        int rowsAffected = 0;
        try {
            PreparedStatement pat = conn.prepareStatement("UPDATE booking_tbl SET  Status=?  WHERE PK_BookingID=? ");
            pat.setString(1, string);
            pat.setInt(2, i);
            
            rowsAffected = pat.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(BookingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsAffected>0;
    }
    
    
    
    
    
    

    @Override
    public boolean addBranch(Branch branch) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `branch_tbl` (`Name`, `PhoneNumber`, `Address`, `City`, `Latitude`, `Longitude`, `Status`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pat.setString(1, branch.getName());
            pat.setString(2, branch.getPhoneNumber());
            pat.setString(3, branch.getAddress());
            pat.setString(4, branch.getCity());
            pat.setBigDecimal(5, branch.getLatitude());
            pat.setBigDecimal(6, branch.getLongitude());
            pat.setBoolean(7, branch.isStatus());
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Branch> getBranches() {
        List<Branch> bramches = new ArrayList<>();
         try {             
            
            Statement statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `branch_tbl`");
            while(resultSet.next()) {
                Branch bramch = new Branch();
                
                bramch.setBranchID(resultSet.getInt("PK_BranchID"));
                bramch.setName(resultSet.getString("Name"));
                bramch.setPhoneNumber(resultSet.getString("PhoneNumber"));
                bramch.setAddress(resultSet.getString("Address"));
                bramch.setCity(resultSet.getString("City"));
                bramch.setLatitude(resultSet.getBigDecimal("Latitude"));
                bramch.setLongitude(resultSet.getBigDecimal("Longitude"));
                bramch.setStatus(resultSet.getBoolean("Status"));
                
                bramches.add(bramch);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return bramches;
    }

    @Override
    public boolean updateBranch(Branch branch) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("UPDATE `branch_tbl` SET `Name`= ?, `PhoneNumber` =?, `Address` =?, `City`=?, `Latitude`=?, `Longitude`=?, `Status`=?  WHERE `PK_BranchID` = ?");
            pat.setString(1, branch.getName());
            pat.setString(2, branch.getPhoneNumber());
            pat.setString(3, branch.getAddress());
            pat.setString(4, branch.getCity());
            pat.setBigDecimal(5, branch.getLatitude());
            pat.setBigDecimal(6, branch.getLongitude());
            pat.setBoolean(7, branch.isStatus());
            pat.setInt(8, branch.getBranchID());
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    
    }

    @Override
    public boolean deleteBranch(int id) {
        int rowsAffected = 0;
        try {
            
            Statement statement = conn.createStatement();
            rowsAffected = statement.executeUpdate("DELETE FROM `branch_tbl` WHERE `PK_BranchID` = '" + id + "'");
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    
    }
    
    
    
    
    

    @Override
    public boolean registerCustomer(Customer customer) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `customer-tbl` ( `Name`, `Address`, `PhoneNumber`, `Gender`, `Email`, `Password`) VALUES (?, ?, ?, ?, ?, ?)");
            pat.setString(1, customer.getName());
            pat.setString(2, customer.getAddress());
            pat.setString(3, customer.getPhoneNumber());
            pat.setString(4, customer.getGender());
            pat.setString(5, customer.getEmail());
            pat.setString(6, customer.getPassword());
            
            
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean checkForCustomerAccount(Customer cstmr) {
        int rawCount = 0;
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `customer-tbl` WHERE `PhoneNumber`='"+cstmr.getPhoneNumber()+"'");
           while(resultSet.next()) {

               rawCount++;


           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return rawCount  > 0;
    }

    @Override
    public Customer LoginCustomer(Customer cstmr) {
        Customer customer = null;
        int rawCount = 0;
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `customer-tbl` WHERE `PhoneNumber`='"+cstmr.getPhoneNumber()+"' AND Password='"+cstmr.getPassword()+"'");
           if(resultSet.next()) {
               customer = new Customer();
               customer.setCustomerID(resultSet.getInt("PK_CustomerID"));
               customer.setEmail(resultSet.getString("Email"));
               customer.setName(resultSet.getString("Name"));
               customer.setAddress(resultSet.getString("Address"));
               customer.setGender(resultSet.getString("Gender"));
               customer.setPhoneNumber(resultSet.getString("PhoneNumber"));
               customer.setPassword(resultSet.getString("Password"));

           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    @Override
    public Customer getCustomer(int customerID) {
        Customer customer = null;
        int rawCount = 0;
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `customer-tbl` WHERE `PK_CustomerID`="+customerID);
           if(resultSet.next()) {
               customer = new Customer();
               customer.setCustomerID(resultSet.getInt("PK_CustomerID"));
               customer.setEmail(resultSet.getString("Email"));
               customer.setName(resultSet.getString("Name"));
               customer.setAddress(resultSet.getString("Address"));
               customer.setGender(resultSet.getString("Gender"));
               customer.setPhoneNumber(resultSet.getString("PhoneNumber"));
//               customer.setPassword(resultSet.getString("Password"));

           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return customer;
    }
    
    
    
    
    
    

    @Override
    public boolean addDriver(Driver driver) throws Exception {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `driver_tbl` (`ImageLocation`, `Name`, `Email`, `PhoneNumber`, `Address`, `DOB`, `BranchID`, `Gender`,`Username`,`Password`,`Status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            pat.setString(1, driver.getImgLocation());
            pat.setString(2, driver.getName());
            pat.setString(3, driver.getEmail());
            pat.setString(4, driver.getContactNumber());
            pat.setString(5, driver.getAddress());
            pat.setString(6, driver.getDOB());
            pat.setInt(7, driver.getBranchID());
            pat.setString(8, driver.getGender());
            pat.setString(9, driver.getUsername());
            pat.setString(10, driver.getPassword());
            pat.setString(11, driver.getStatus());
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Driver> getDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `driver_tbl`");
           while(resultSet.next()) {
               Driver driver = new Driver();

               driver.setId(resultSet.getInt("PK_DriverID"));
               driver.setImgLocation(resultSet.getString("ImageLocation"));
               driver.setName(resultSet.getString("Name"));
               driver.setEmail(resultSet.getString("Email"));
               driver.setContactNumber(resultSet.getString("PhoneNumber"));
               driver.setAddress(resultSet.getString("Address"));
               driver.setDOB(resultSet.getString("DOB"));
               driver.setBranchID(resultSet.getInt("BranchID"));
               driver.setGender(resultSet.getString("Gender"));
               driver.setUsername(resultSet.getString("Username"));
               driver.setStatus(resultSet.getString("Status"));

               drivers.add(driver);
           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return drivers;
    }

    @Override
    public boolean updateDriver(Driver driver) {
        int rowsAffected = 0;
        try {
            
            String query = "UPDATE `driver_tbl` SET  `ImageLocation`=?, `Name`= ?, `Email` =?, `PhoneNumber` =?, `Address`=?, `DOB`=?, `BranchID`=?, `Gender`=?, `Username`=? , `Status`=? " ;
            if(!driver.getPassword().isEmpty()){
                query +=", `Password`=?";
            }
            
            query += " WHERE `PK_DriverID` = ?";
            
            PreparedStatement pat = conn.prepareStatement(query);
            pat.setString(1, driver.getImgLocation());
            pat.setString(2, driver.getName());
            pat.setString(3, driver.getEmail());
            pat.setString(4, driver.getContactNumber());
            pat.setString(5, driver.getAddress());
            pat.setString(6, driver.getDOB());
            pat.setInt(7, driver.getBranchID());
            pat.setString(8, driver.getGender());
            pat.setString(9, driver.getUsername());
            pat.setString(10, driver.getStatus());
            
            if(!driver.getPassword().isEmpty()){
                pat.setString(11,driver.getPassword());               
                pat.setInt(12, driver.getId());
            }else{
                pat.setInt(11, driver.getId());
            }
            
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    
    }

    @Override
    public boolean updateDriverStatus(int i, String status) {
        int rowsAffected = 0;
        try {
            
            String query = "UPDATE `driver_tbl` SET  `Status`=?  WHERE `PK_DriverID` = ?" ;
            
            PreparedStatement pat = conn.prepareStatement(query);
            pat.setString(1, status);
            pat.setInt(2, i);

            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    }

    @Override
    public Driver DriverLogin(Driver driver) {
        
        Driver driver1 = null;
        int rawCount = 0;
        try {             

           Statement statement = conn.createStatement();
           String query = "SELECT * FROM `driver_tbl` WHERE `Email`=? AND Password=?" ;
           
           PreparedStatement pat = conn.prepareStatement(query);
           pat.setString(1, driver.getEmail());
           pat.setString(2, driver.getPassword());
           
           ResultSet resultSet = pat.executeQuery();
           
           
           if(resultSet.next()) {
               driver1 = new Driver();
               driver1.setId(resultSet.getInt("PK_DriverID"));
               driver1.setImgLocation(resultSet.getString("ImageLocation"));
               driver1.setName(resultSet.getString("Name"));
               driver1.setEmail(resultSet.getString("Email"));
               driver1.setContactNumber(resultSet.getString("PhoneNumber"));
               driver1.setAddress(resultSet.getString("Address"));
               driver1.setDOB(resultSet.getString("DOB"));
               driver1.setBranchID(resultSet.getInt("BranchID"));
               driver1.setGender(resultSet.getString("Gender"));
               driver1.setUsername(resultSet.getString("Username"));
               driver1.setPassword(resultSet.getString("Password"));
               driver1.setStatus(resultSet.getString("Status"));
               

           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return driver1;
    }
    
    
    

    @Override
    public boolean AddLocation(Location location) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `location_tbl` (`BranchID`, `Source`, `Destination`, `Distance`) VALUES (?, ?, ?, ?)");
            pat.setInt(1, location.getBranchID());
            pat.setString(2, location.getSource());
            pat.setString(3, location.getDestination());
            pat.setBigDecimal(4, location.getDistance());
            
            
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT location_tbl.*, branch_tbl.City  FROM `location_tbl`  INNER JOIN branch_tbl ON location_tbl.BranchID = branch_tbl.PK_BranchID ");
           while(resultSet.next()) {
               Location locaiton = new Location();

               locaiton.setLocationID(resultSet.getInt("PK_LocationID"));
               locaiton.setBranchID(resultSet.getInt("BranchID"));
               locaiton.setSource(resultSet.getString("Source"));
               locaiton.setDestination(resultSet.getString("Destination"));
               locaiton.setDistance(resultSet.getBigDecimal("Distance"));
               locaiton.setBranchCity(resultSet.getString("City"));



               locations.add(locaiton);
           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return locations;
    }

    @Override
    public List<Location> getLocationsNames() {
        List<Location> locations = new ArrayList<>();
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT DISTINCT Source  FROM `location_tbl`  ");
           while(resultSet.next()) {
               Location locaiton = new Location();

//               locaiton.setLocationID(resultSet.getInt("PK_LocationID"));
//               locaiton.setBranchID(resultSet.getInt("BranchID"));
               locaiton.setSource(resultSet.getString("Source"));
//               locaiton.setDestination(resultSet.getString("Destination"));
//               locaiton.setDistance(resultSet.getBigDecimal("Distance"));
//               locaiton.setBranchCity(resultSet.getString("City"));



               locations.add(locaiton);
           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return locations;
    }

    @Override
    public List<Location> getRelatedLocations(String loction) {
        List<Location> locations = new ArrayList<>();
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT *  FROM `location_tbl`  WHERE Source='"+loction+"'");
           while(resultSet.next()) {
               Location locaiton = new Location();

               locaiton.setLocationID(resultSet.getInt("PK_LocationID"));
               locaiton.setBranchID(resultSet.getInt("BranchID"));
               locaiton.setSource(resultSet.getString("Source"));
               locaiton.setDestination(resultSet.getString("Destination"));
               locaiton.setDistance(resultSet.getBigDecimal("Distance"));
               



               locations.add(locaiton);
           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return locations;
    }
    
    
    

    
    @Override
    public boolean addVCategory(VehicleCategory VCategory) {
        int rowsAffected = 0;
        try {
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `vehiclecategory_tbl` (`ImageFileLocation`, `CategoryName`) VALUES (?, ?)");
            pat.setString(1, VCategory.getImageFileLocation());
            pat.setString(2, VCategory.getCategoryName());
         //   pat.setBlob(2, VCategory.getCategoryImg());
            
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    
    }

    @Override
    public List<VehicleCategory> getCategories() {
        List<VehicleCategory> vCategories = new ArrayList<>();
        try {             

           
           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `vehiclecategory_tbl`");
           while(resultSet.next()) {
               VehicleCategory VCategory = new VehicleCategory();

               VCategory.setCategoryID(resultSet.getInt("CategoryID"));
               VCategory.setCategoryName(resultSet.getString("CategoryName"));
               VCategory.setImageFileLocation(resultSet.getString("ImageFileLocation"));

               vCategories.add(VCategory);
           }
       } catch(Exception e) {
           System.out.println(e);
       }
       return vCategories;
    
    }

    @Override
    public boolean updateVCategory(VehicleCategory vc) {
        int rowsAffected = 0;
        try {

            PreparedStatement pat = conn.prepareStatement("UPDATE `vehiclecategory_tbl` SET `ImageFileLocation`= ?, `CategoryName` =?  WHERE `CategoryID` = ? ");
            pat.setString(1, vc.getImageFileLocation());
            pat.setString(2, vc.getCategoryName());
            pat.setInt(3, vc.getCategoryID());

            
            
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
        
    
    }
    
    
    
    
    

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `gocheeta`.`vehicle_tbl` (`PK_NumberPlate`, `Name`, `ImagePath`, `Seat`, `color`, `BranchID`, `CategoryID`,`Status`) VALUES (?, ?, ?, ?, ?, ?, ?,?)");
            pat.setString(1, vehicle.getPlateNumber());
            pat.setString(2, vehicle.getName());
            pat.setString(3, vehicle.getImagePath());
            pat.setInt(4, vehicle.getSeat());
            pat.setString(5, vehicle.getColor());
            pat.setInt(6, vehicle.getBranchID());
            pat.setInt(7, vehicle.getCategoryID());
            pat.setString(8, vehicle.getStatus());
            
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    }
    
    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("UPDATE `vehicle_tbl` SET  `Name` = ?, `ImagePath` = ?, `Seat` = ?, `color` = ?, `BranchID` = ?, `CategoryID` = ?, `Status` = ? WHERE (`PK_NumberPlate` = ?);");
            pat.setString(1, vehicle.getName());
            pat.setString(2, vehicle.getImagePath());
            pat.setInt(3, vehicle.getSeat());
            pat.setString(4, vehicle.getColor());
            pat.setInt(5, vehicle.getBranchID());
            pat.setInt(6, vehicle.getCategoryID());
            pat.setString(7, vehicle.getStatus());
            pat.setString(8, vehicle.getPlateNumber());
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    }
    
    
    
    @Override
    public boolean AddVehicleAccessibility(Vehicle vehicle){
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `accessibility_vehicles_tbl` (`PK_DriverID`, `PK_NumberPlate`, `VehicleName`) VALUES (?, ?, ?)");
            
            for(int driverId : vehicle.getDriverIds()){
                pat.setInt(1, driverId);
                pat.setString(2, vehicle.getPlateNumber());
                pat.setString(3, vehicle.getName());
                pat.addBatch();
            }
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeBatch().length;
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    }
    
    
    

    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
         try {             
            
            Statement statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `vehicle_tbl`");
            while(resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                
                vehicle.setPlateNumber(resultSet.getString("PK_NumberPlate"));
                vehicle.setName(resultSet.getString("Name"));
                vehicle.setBranchID(resultSet.getInt("BranchID"));
                vehicle.setCategoryID(resultSet.getInt("CategoryID"));
                vehicle.setImagePath(resultSet.getString("ImagePath"));
                vehicle.setSeat(resultSet.getInt("Seat"));
                vehicle.setStatus(resultSet.getString("Status"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setBaseFare(resultSet.getBigDecimal("BaseFare"));
                
                
                
                vehicles.add(vehicle);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return vehicles;
    }

    @Override
    public List<Integer> getVehicleAccess(Vehicle vhcl) {
        List<Integer> DriverIds = new ArrayList<>();
         try {             
            
            PreparedStatement pat = conn.prepareStatement("SELECT * FROM `accessibility_vehicles_tbl` WHERE `PK_NumberPlate` = ?");
            pat.setString(1, vhcl.getPlateNumber());
            
            ResultSet resultSet = pat.executeQuery();
            while(resultSet.next()) {
                
                DriverIds.add(resultSet.getInt("PK_DriverID"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return DriverIds;
    }

    @Override
    public boolean deleteVehicleAccess(Vehicle vhcl,int DriverID) {
        int rowsAffected = 0;
        try {             
            
            PreparedStatement pat = conn.prepareStatement("DELETE FROM `accessibility_vehicles_tbl` WHERE (`PK_NumberPlate` = ?) and (`PK_DriverID` = ?)");
            pat.setString(1, vhcl.getPlateNumber());
            pat.setInt(2, DriverID);
            
            rowsAffected = pat.executeUpdate();
            
            
        } catch(Exception e) {
            System.out.println(e);
        }
        
        return rowsAffected > 0;
    }

    @Override
    public boolean AddOneVehicleAccessibility(Vehicle vehicle, int i) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `accessibility_vehicles_tbl` (`PK_DriverID`, `PK_NumberPlate`, `VehicleName`) VALUES (?, ?, ?)");
            pat.setInt(1, i);
            pat.setString(2, vehicle.getPlateNumber());
            pat.setString(3, vehicle.getName());
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    
    }

    @Override
    public boolean updateVehicleStatus(String numberPlate, String status) {
        int rowsAffected = 0;
        try {    
            PreparedStatement pat = conn.prepareStatement("UPDATE `vehicle_tbl` SET  `Status` = ? WHERE (`PK_NumberPlate` = ?)");
            pat.setString(1, status);
            pat.setString(2, numberPlate);
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Integer> getVehicleAccessAvailable(Vehicle vhcl) {
        List<Integer> DriverIds = new ArrayList<>();
         try {             
            
            PreparedStatement pat = conn.prepareStatement("SELECT * FROM `accessibility_vehicles_tbl` WHERE `PK_NumberPlate` = ? AND Status='AvaIlable'");
            pat.setString(1, vhcl.getPlateNumber());
            
            ResultSet resultSet = pat.executeQuery();
            while(resultSet.next()) {
                
                DriverIds.add(resultSet.getInt("PK_DriverID"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return DriverIds;
    }
    
}
