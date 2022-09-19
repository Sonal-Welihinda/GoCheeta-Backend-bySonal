/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import lk.sonal.gocheeta.server.Models.Customer;

/**
 *
 * @author sonal
 */
public interface CustomerDao {
    public boolean registerCustomer(Customer customer);
    public boolean checkForCustomerAccount(Customer customer);
    public Customer LoginCustomer(Customer customer);
    public Customer getCustomer(int customerID);
}
