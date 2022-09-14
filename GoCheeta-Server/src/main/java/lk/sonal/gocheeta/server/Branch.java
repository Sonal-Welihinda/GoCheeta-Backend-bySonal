/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import java.math.BigDecimal;

/**
 *
 * @author sonal
 */
public class Branch {
    int BranchID;
    String Name,PhoneNumber,Address,City;
    boolean Status = false;
    BigDecimal Latitude ,Longitude;

    public Branch() {
    }

    public Branch(int BranchID, String Name, String PhoneNumber, String Address, String City, BigDecimal Latitude, BigDecimal Longitude) {
        this.BranchID = BranchID;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.City = City;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }
    
    

    public int getBranchID() {
        return BranchID;
    }

    public void setBranchID(int BranchID) {
        this.BranchID = BranchID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public BigDecimal getLatitude() {
        return Latitude;
    }

    public void setLatitude(BigDecimal Latitude) {
        this.Latitude = Latitude;
    }

    public BigDecimal getLongitude() {
        return Longitude;
    }

    public void setLongitude(BigDecimal Longitude) {
        this.Longitude = Longitude;
    }
    
    
    
    
}
