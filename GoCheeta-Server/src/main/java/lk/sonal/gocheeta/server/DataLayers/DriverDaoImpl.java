/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.sonal.gocheeta.server.Models.Branch;
import lk.sonal.gocheeta.server.Models.Customer;
import lk.sonal.gocheeta.server.Models.Driver;
import lk.sonal.gocheeta.server.MySqlUtill;

/**
 *
 * @author sonal
 */
public class DriverDaoImpl implements DriverDao {
    
    Connection conn;
    
    public DriverDaoImpl(){
        conn = MySqlUtill.getInstance();
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
    
}
