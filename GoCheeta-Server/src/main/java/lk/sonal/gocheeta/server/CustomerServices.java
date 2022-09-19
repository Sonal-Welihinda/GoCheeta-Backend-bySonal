/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sonal
 */

@Path("Customer")
public class CustomerServices {
    
    BL BLayer ; 
    public CustomerServices() {
        BLayer = BL.getInstance();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRegisterCustomer(String json) {
        String result = BLayer.RegisterCustomer(json);
        if (result.split(",")[0].equals("Success")) {
        return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity(result.split(",")[1]).build();
        }
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login")
    public Response LoginCustomer(String json) {
        String result = BLayer.CustomerLogin(json);
        if (!result.contains("error,")) {
            return Response.status(201).entity(result).build();
        } else {
            return Response.status(501).entity(result.split(",")[1]).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{token}")
    public String getCustomerDetail(@PathParam("token") String token ){
        BLayer.getCustomerDetails(token);
        return "";
    }
    
}
