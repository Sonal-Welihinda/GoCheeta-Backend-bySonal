/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.sonal.gocheeta.server.Models.Booking;
import lk.sonal.gocheeta.server.Models.Driver;
import lk.sonal.gocheeta.server.MySqlUtill;

/**
 *
 * @author sonal
 */
public class BookingDaoImpl implements BookingDao{
    
    Connection conn;
    
    public BookingDaoImpl(){
        conn = MySqlUtill.getInstance();
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
    
    
    
}
