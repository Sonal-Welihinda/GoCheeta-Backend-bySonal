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
import lk.sonal.gocheeta.server.Models.Branch;
import lk.sonal.gocheeta.server.MySqlUtill;

/**
 *
 * @author sonal
 */
public class BranchDaoImpl implements BranchDao{
    
    Connection conn;
    
    public BranchDaoImpl(){
        conn = MySqlUtill.getInstance();
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
    
}
