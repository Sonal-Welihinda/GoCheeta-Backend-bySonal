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
import lk.sonal.gocheeta.server.Models.Location;
import lk.sonal.gocheeta.server.Models.Vehicle;
import lk.sonal.gocheeta.server.MySqlUtill;

/**
 *
 * @author sonal
 */
public class LocationDaoImpl implements LocationDao{

    
    Connection conn;
    
    public LocationDaoImpl(){
        conn = MySqlUtill.getInstance();
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
    
}
