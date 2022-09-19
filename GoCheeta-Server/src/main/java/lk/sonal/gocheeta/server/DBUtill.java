package lk.sonal.gocheeta.server;


import lk.sonal.gocheeta.server.Models.Admin;
import lk.sonal.gocheeta.server.Models.Branch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sonal
 */
public class DBUtill {
    static final String DB_URL = "jdbc:mysql://localhost:3306/gocheeta?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "sonal1234";
    
    public boolean addAdmin(Admin amin) {
        int rowsAffected = 0;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            rowsAffected = statement.executeUpdate("INSERT INTO `admin_tbl` (`Name`, `Email`, `PhoneNumber`, `Address`, `DOB`, `AccType`, `BranchID`, `Gender`, `Username`, `Password`) VALUES ('"+amin.getName()+"', '"+amin.getEmail()+"', '"+amin.getPhoneNumber()+"', '"+amin.getAddress()+"', '"+amin.getDOB()+"', '"+amin.getAccType()+"', '"+amin.getBranch()+"', '"+amin.getGender()+"', '"+amin.getUsername()+"', '"+amin.getPassword()+"');");
           
            
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    }
    
    public List<Admin> getAdmins() {
        List<Admin> admins = new ArrayList<>();
         try {             
            
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
    
    public List<Admin> getFilterAdmins(String branch,String accTYpe, String searchText) {
        boolean MultipleFilters = false;
        List<Admin> admins = new ArrayList<>();
         try {             
            
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
    
    public boolean updateAdmin(Admin admin) {
        int rowsAffected = 0;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
    
    public boolean deleteAdmin(int id) {
        int rowsAffected = 0;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            rowsAffected = statement.executeUpdate("DELETE FROM `admin_tbl` WHERE `PK_AdminID` = '" + id + "'");
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    }
    
    
//    Branch
    
    public boolean addBranch(Branch branch) {
        int rowsAffected = 0;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
    
    public List<Branch> getBranches() {
        List<Branch> bramches = new ArrayList<>();
         try {             
            
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
    
    
    public boolean updateBranch(Branch branch) {
        int rowsAffected = 0;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
    
    
    public boolean deleteBranch(int id) {
        int rowsAffected = 0;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            rowsAffected = statement.executeUpdate("DELETE FROM `branch_tbl` WHERE `PK_BranchID` = '" + id + "'");
        } catch(Exception e) {
            System.out.println(e);
        }
        return rowsAffected > 0;
    }
    
    
    
//    Vehicle Cateogry
    
    public boolean addVCategory(VehicleCategory VCategory) {
        int rowsAffected = 0;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
    
}
