/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

@Path("Vehicle")
public class VehicleServices {
    
    BL BLayer ; 

    public VehicleServices() {
        BLayer = BL.getInstance();
        
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Category")
    public Response addVCategory(String json) {
        
        String result;  
        try {
            result = BLayer.addVCategory(json);
            if (result.split(",")[0].equals("Success")) {
            return Response.status(201).entity("Successfully added").build();
            } else {
                return Response.status(501).entity("Error occurred").build();
            }
        } catch (Exception ex) {
            Logger.getLogger(VehicleServices.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(501).entity(ex).build();
        }
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Category")
    public String getVCategories() {
        
        return BLayer.getVCategories();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Category")
    public Response updateVCategory(String json){
        String result;  
        try {
            result = BLayer.updateVCategory(json);
            if (result.split(",")[0].equals("Success")) {
                return Response.status(201).entity("Successfully added").build();
            } else {
                return Response.status(501).entity("Error occurred").build();
            }
        } catch (Exception ex) {
            Logger.getLogger(VehicleServices.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(501).entity(ex).build();
        }
    }
    
//    
//    Vehicle 
//    
//    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVehicle(String json) {
        
        String result;  
        try {
            result = BLayer.addVehicle(json);
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
    public String getVehicle() {
        return BLayer.getVehicles();
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateVehicle(String json) {
        try {
            String result = BLayer.UpdateVehicle(json);
            if (result.split(",")[0].equals("Success")) {
                return Response.status(201).entity("Successfully updated").build();
            } else {
                return Response.status(501).entity("Error occurred").build();
            }
        } catch (Exception ex) {
            Logger.getLogger(VehicleServices.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(501).entity(ex.getMessage()).build();
        }

    }
    
}
