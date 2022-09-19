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
import lk.sonal.gocheeta.server.VehicleCategory;

/**
 *
 * @author sonal
 */
public class VehicleCategoryDaoImpl implements VehicleCategoryDao {
    
    Connection conn;
    
    public VehicleCategoryDaoImpl(){
        conn = MySqlUtill.getInstance();
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
    
}
