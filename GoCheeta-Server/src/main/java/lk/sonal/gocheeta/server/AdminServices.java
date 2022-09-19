/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sonal
 */
@Path("admin")
public class AdminServices {
    
    BL BLayer ; 

    public AdminServices() {
        BLayer = BL.getInstance();
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdmins() {
        
        return BLayer.getAdmins();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAdmin(String json) {
        String result = BLayer.addAdmin(json);  
        if (result.split(",")[0].equals("Success")) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response UpdateAdmin(String json) {
        String result = BLayer.UpdateAdmin(json);  
        if (result.split(",")[0].equals("Success")) {
            return Response.status(201).entity("Successfully Updated").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteAdmin(@PathParam("id") int id) {
        String result = BLayer.deleteAdmin(id);    
        if (result.split(",")[0].equals("Success")) {
            return Response.status(201).entity("Admin removed ").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/FilterAdmin")
    public String getFiltersAdmins(@QueryParam("branchID") String bID,@QueryParam("AccType") String AccType ,@QueryParam("SearchTxt") @DefaultValue("") String SearchTxt ) {
        return BLayer.getFiltersAdmins(bID, AccType, SearchTxt);
    }
    
}


   
