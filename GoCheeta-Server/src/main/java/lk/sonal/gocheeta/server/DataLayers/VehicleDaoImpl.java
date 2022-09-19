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
import lk.sonal.gocheeta.server.Models.Vehicle;
import lk.sonal.gocheeta.server.MySqlUtill;

/**
 *
 * @author sonal
 */
public class VehicleDaoImpl implements VehicleDao{
    
    Connection conn;
    
    public VehicleDaoImpl(){
        conn = MySqlUtill.getInstance();
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
