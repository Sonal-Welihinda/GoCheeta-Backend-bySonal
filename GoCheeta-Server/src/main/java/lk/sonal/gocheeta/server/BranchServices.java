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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sonal
 */

@Path("branch")
public class BranchServices {
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBranches() {
        DBUtill util = new DBUtill();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(util.getBranches());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBranch(String json) {
        Gson gson = new GsonBuilder().create();
        Branch branch = gson.fromJson(json, Branch.class);
        DBUtill util = new DBUtill();
        boolean result = util.addBranch(branch);  
        if (result) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBranch(String json) {
        Gson gson = new GsonBuilder().create();
        Branch branch = gson.fromJson(json, Branch.class);
        DBUtill util = new DBUtill();
        boolean result = util.updateBranch(branch);    
        if (result) {
            return Response.status(201).entity("Successfully updated").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
       DBUtill util = new DBUtill();
        boolean result = util.deleteBranch(id);    
        if (result) {
            return Response.status(201).entity("Branch removed ").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    
}
