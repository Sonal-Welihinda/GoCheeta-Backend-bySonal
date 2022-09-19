/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonal
 */
public class MySqlUtill {
    static final String DB_URL = "jdbc:mysql://localhost:3306/gocheeta?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "sonal1234";
    
    static Connection conn;
    
    public static Connection getInstance(){
        try {
            if(conn == null){
                conn =DriverManager.getConnection(DB_URL, USER, PASS);
            }
            
            return  conn;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlUtill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  conn;
    }
}
