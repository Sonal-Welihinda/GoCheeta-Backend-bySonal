/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("admin")
public class AdminServices {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdmins() {
        DBUtill util = new DBUtill();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(util.getAdmins());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAdmin(String json) {
        Gson gson = new GsonBuilder().create();
        Admin admin = gson.fromJson(json, Admin.class);
        DBUtill util = new DBUtill();
        boolean result = util.addAdmin(admin);  
        if (result) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response UpdateAdmin(String json) {
        Gson gson = new GsonBuilder().create();
        Admin admin = gson.fromJson(json, Admin.class);
        DBUtill util = new DBUtill();
        boolean result = util.updateAdmin(admin);  
        if (result) {
            return Response.status(201).entity("Successfully Updated").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
       DBUtill util = new DBUtill();
        boolean result = util.deleteAdmin(id);    
        if (result) {
            return Response.status(201).entity("Admin removed ").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
}


   
