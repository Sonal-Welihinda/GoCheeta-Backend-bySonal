/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.Models;

import java.math.BigDecimal;

/**
 *
 * @author sonal
 */
public class Booking {
    int bookingID;
    String Source,Destination,CustomerName,CustomerPhoneNumber;
    int CustormerId;
    int DriversId;
    Vehicle vehicle; 
    BigDecimal price,Distance;
    String CreatedDate,BookingTime,Status,VehicleID;

    public Booking() {
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String CustomerPhoneNumber) {
        this.CustomerPhoneNumber = CustomerPhoneNumber;
    }

    
    
    
    public String getStatus() {
        return Status;
    }
    
    public String getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(String VehicleID) {
        this.VehicleID = VehicleID;
    }
    
    
    
    public void setStatus(String Status) {
        this.Status = Status;
    }
    

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getBookingTime() {
        return BookingTime;
    }

    public void setBookingTime(String BookingTime) {
        this.BookingTime = BookingTime;
    }
    
    
    

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getDriversId() {
        return DriversId;
    }

    public void setDriversId(int DriversId) {
        this.DriversId = DriversId;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
    }
    

    

    public int getCustormerId() {
        return CustormerId;
    }

    public void setCustormerId(int CustormerId) {
        this.CustormerId = CustormerId;
    }
    
    
    
    public BigDecimal Calculate(){
        return vehicle.getBaseFare().multiply(Distance);
    }
    

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDistance() {
        return Distance;
    }

    public void setDistance(BigDecimal Distance) {
        this.Distance = Distance;
    }
    
    
    
}
