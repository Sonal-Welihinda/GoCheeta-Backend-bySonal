/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.sonal.gocheeta.server.Models.Admin;
import lk.sonal.gocheeta.server.MySqlUtill;

/**
 *
 * @author sonal
 */
public class AdminDaoImpl implements AdminDao{
    
    Connection conn;
    
    public AdminDaoImpl(){
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

               admin.setId(resultSet.getInt("PK_AdminID"));
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
                
                admin.setId(resultSet.getInt("PK_AdminID"));
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
    
}
