/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

/**
 *
 * @author sonal
 */
public class DaoFactory {
    
    public static DaoInterface getDatabase(String type){ 
        if (type.equalsIgnoreCase("mysql")){
            return new SQLDB_Class();
        }else{
            //Add Different Database
            return new SQLDB_Class();
        }
    }
}
