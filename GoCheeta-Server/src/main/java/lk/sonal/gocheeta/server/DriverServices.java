/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sonal
 */

@Path("Drtver")
public class DriverServices {
     
    BL BLayer ; 

    public DriverServices() {
        BLayer = BL.getInstance();  
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDriver(String json) {
        
        String result;  
        try {
            result = BLayer.addDriver(json);
            if (result.split(",")[0].equals("Success")) {
                return Response.status(201).entity("Successfully added").build();
            } else {
                return Response.status(501).entity(result.split(",")[1]).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(VehicleServices.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(501).entity(ex).build();
        }
        
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDrivers() {
        
        return BLayer.getDrivers();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDriver(String json) {
        String result = BLayer.UpdateDriver(json);    
        if (result.split(",")[0].equals("Success")) {
            return Response.status(201).entity("Successfully updated").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public Response DriverLogin(String json ) {
        String result = BLayer.LoginDriver(json);    
        if (result.split(",")[0].equals("Error")) {
            return Response.status(501).entity("No user found").build();
        }
        return Response.status(201).entity(result).build();
    }
    
    
    
    
}
