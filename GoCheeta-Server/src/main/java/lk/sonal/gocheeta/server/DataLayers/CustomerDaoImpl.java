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
import lk.sonal.gocheeta.server.Models.Customer;
import lk.sonal.gocheeta.server.Models.Location;
import lk.sonal.gocheeta.server.MySqlUtill;

/**
 *
 * @author sonal
 */
public class CustomerDaoImpl implements CustomerDao {
    
    Connection conn;
    
    public CustomerDaoImpl(){
        conn = MySqlUtill.getInstance();
    }
    

    @Override
    public boolean registerCustomer(Customer customer) {
        int rowsAffected = 0;
        try {
            
            PreparedStatement pat = conn.prepareStatement("INSERT INTO `customer-tbl` ( `Name`, `Address`, `PhoneNumber`, `Gender`, `Email`, `Password`) VALUES (?, ?, ?, ?, ?, ?)");
            pat.setString(1, customer.getName());
            pat.setString(2, customer.getAddress());
            pat.setString(3, customer.getPhoneNumber());
            pat.setString(4, customer.getGender());
            pat.setString(5, customer.getEmail());
            pat.setString(6, customer.getPassword());
            
            
            
//            Statement statement = conn.createStatement();
            rowsAffected = pat.executeUpdate();
           
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
            
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean checkForCustomerAccount(Customer cstmr) {
        int rawCount = 0;
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `customer-tbl` WHERE `PhoneNumber`='"+cstmr.getPhoneNumber()+"'");
           while(resultSet.next()) {

               rawCount++;


           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return rawCount  > 0;
    }

    @Override
    public Customer LoginCustomer(Customer cstmr) {
        Customer customer = null;
        int rawCount = 0;
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `customer-tbl` WHERE `PhoneNumber`='"+cstmr.getPhoneNumber()+"' AND Password='"+cstmr.getPassword()+"'");
           if(resultSet.next()) {
               customer = new Customer();
               customer.setCustomerID(resultSet.getInt("PK_CustomerID"));
               customer.setEmail(resultSet.getString("Email"));
               customer.setName(resultSet.getString("Name"));
               customer.setAddress(resultSet.getString("Address"));
               customer.setGender(resultSet.getString("Gender"));
               customer.setPhoneNumber(resultSet.getString("PhoneNumber"));
               customer.setPassword(resultSet.getString("Password"));

           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    @Override
    public Customer getCustomer(int customerID) {
        Customer customer = null;
        int rawCount = 0;
        try {             

           Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM `customer-tbl` WHERE `PK_CustomerID`="+customerID);
           if(resultSet.next()) {
               customer = new Customer();
               customer.setCustomerID(resultSet.getInt("PK_CustomerID"));
               customer.setEmail(resultSet.getString("Email"));
               customer.setName(resultSet.getString("Name"));
               customer.setAddress(resultSet.getString("Address"));
               customer.setGender(resultSet.getString("Gender"));
               customer.setPhoneNumber(resultSet.getString("PhoneNumber"));
//               customer.setPassword(resultSet.getString("Password"));

           }
        } catch(Exception e) {
            System.out.println(e);
        }
        return customer;
    }
    
    
    
    
    
}
