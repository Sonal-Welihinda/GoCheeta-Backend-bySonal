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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sonal
 */

@Path("Location")
public class LocationServices {
    
    BL BLayer ; 

    public LocationServices() {
        BLayer = BL.getInstance();
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getLocations() {
        
        return BLayer.getLocations();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("All/Noduplicate")
    public String getLocationsNames() {
        
        return BLayer.getLocationsNames();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Related/{location}")
    public String getLocationsNafmes(@PathParam("location") String location) {
        
        return BLayer.getRelatedLocations(location);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLocation(String json) {
        
        String result;  
        try {
            result = BLayer.addLocation(json);
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
    
    
}
