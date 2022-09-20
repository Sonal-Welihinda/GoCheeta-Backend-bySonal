/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.util.List;
import lk.sonal.gocheeta.server.Models.Admin;
import lk.sonal.gocheeta.server.Models.Booking;
import lk.sonal.gocheeta.server.Models.Branch;
import lk.sonal.gocheeta.server.Models.Customer;
import lk.sonal.gocheeta.server.Models.Driver;
import lk.sonal.gocheeta.server.Models.Location;
import lk.sonal.gocheeta.server.Models.Vehicle;
import lk.sonal.gocheeta.server.VehicleCategory;

/**
 *
 * @author sonal
 */
public interface DaoInterface {
    public boolean addAdmin(Admin amin);
    public List<Admin> getAdmins();
    public List<Admin> getFilterAdmins(String branch,String accTYpe, String searchText);
    public boolean updateAdmin(Admin admin);
    public boolean deleteAdmin(int id);
    
    
    public boolean AddBookng(Booking booking);
    public Booking getDriversActiveBooking(int DriverID);
    public boolean updateBookingStatus (int bookingID,String status);
    
    
    public boolean addBranch(Branch branch);
    public List<Branch> getBranches();
    public boolean updateBranch(Branch branch);
    public boolean deleteBranch(int id);
    
    
    public boolean registerCustomer(Customer customer);
    public boolean checkForCustomerAccount(Customer customer);
    public Customer LoginCustomer(Customer customer);
    public Customer getCustomer(int customerID);
    
    
    public boolean addDriver(Driver driver) throws Exception ;
    public List<Driver> getDrivers();
    public boolean updateDriver(Driver driver);
    public boolean updateDriverStatus(int DriverID,String status);
    public Driver DriverLogin(Driver driver);
    
    
    
    public boolean AddLocation(Location location);
    public List<Location> getLocations();
    public List<Location> getLocationsNames();
    public List<Location> getRelatedLocations(String location);
    
    
    public boolean addVCategory(VehicleCategory VCategory);
    public boolean updateVCategory(VehicleCategory VCategory);
    public List<VehicleCategory> getCategories();
    
    
    
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
