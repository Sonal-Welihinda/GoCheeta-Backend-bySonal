/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import java.math.BigDecimal;
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
@Path("Booking")
public class BookingService {
    
    BL BLayer ; 

    public BookingService() {
        BLayer = BL.getInstance();
        
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBooking(String json) {
        String result = BLayer.addBooking(json);
        if (result.split(",")[0].equals("Success")) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity(result.split(",")[1]).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllBooking() {
        String result = BLayer.getAllBookings();
        
        return result;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{i}")
    public String getDriverActiveBooking(@PathParam("i") int  i) {
        String result = BLayer.getDriversActiveBookings(i);
        
        return result;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/History/{i}")
    public String getDriverCompletedBooking(@PathParam("i") int  i) {
        String result = BLayer.getDriversCompletedBookings(i);
        
        return result;
    }
    
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Status/{i}/{Status}")
    public Response updateBookingStatus(@PathParam("i") int  i,@PathParam("Status") String  Status){
        boolean result = BLayer.updateBookingStatus(i,Status);
        if (result) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity("Unable to Updated").build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Rating")
    public Response updateBookingRating(String json){
        
        boolean result = BLayer.updateBookingRating(json);
        if (result) {
            return Response.status(201).entity("Successfully Added Rating").build();
        } else {
            return Response.status(501).entity("Unable to Add rating").build();
        }
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Customer/History/{i}")
    public String getCustomerBookingHistory(@PathParam("i") int  i) {
        String result = BLayer.getCustomerBookingHistory(i);
        
        return result;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Sales")
    public String getBookingSales() {
        String result = BLayer.getBookingSales("");
        
        return result;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Customer/{i}")
    public String getCustomerOngoingBooking(@PathParam("i") int  customerID) {
        String result = BLayer.getCustomerActiveBookings(customerID);
        
        return result;
    }
    
    
}
