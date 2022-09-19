/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.util.List;
import lk.sonal.gocheeta.server.Models.Vehicle;

/**
 *
 * @author sonal
 */
public interface VehicleDao {
    public boolean addVehicle(Vehicle vehicle);
    public boolean updateVehicle(Vehicle vehicle);
    public boolean updateVehicleStatus(String numberPlate, String status);
    public boolean deleteVehicleAccess(Vehicle vehicle, int DriverID);
    public boolean AddVehicleAccessibility(Vehicle vehicle);
    public boolean AddOneVehicleAccessibility(Vehicle vehicle,int DriverID);
    public List<Vehicle> getVehicles();
    public List<Integer> getVehicleAccess(Vehicle vehicle);
    public List<Integer> getVehicleAccessAvailable(Vehicle vehicle);
}
