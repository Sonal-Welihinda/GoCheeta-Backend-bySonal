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
public class Location {
    int locationID,branchID;
    String source,destination,BranchCity;
    BigDecimal Distance;

    public Location() {
    }

    public String getBranchCity() {
        return BranchCity;
    }

    public void setBranchCity(String BranchCity) {
        this.BranchCity = BranchCity;
    }
    
    

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getDistance() {
        return Distance;
    }

    public void setDistance(BigDecimal Distance) {
        this.Distance = Distance;
    }
    
    
}
