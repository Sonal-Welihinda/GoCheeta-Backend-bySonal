/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sonal
 */

@Path("Vehicle")
public class VehicleServices {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Category")
    public Response addBranch(String json) {
        Gson gson = new GsonBuilder().create();
        VehicleCategory vCategory = gson.fromJson(json, VehicleCategory.class);
        DBUtill util = new DBUtill();
        boolean result = util.addVCategory(vCategory);  
        if (result) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    
    
}
