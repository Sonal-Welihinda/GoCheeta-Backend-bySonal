/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.util.List;
import lk.sonal.gocheeta.server.Models.Driver;

/**
 *
 * @author sonal
 */
public interface DriverDao {
    public boolean addDriver(Driver driver) throws Exception ;
    public List<Driver> getDrivers();
    public boolean updateDriver(Driver driver);
    public boolean updateDriverStatus(int DriverID,String status);
    public Driver DriverLogin(Driver driver);
}
