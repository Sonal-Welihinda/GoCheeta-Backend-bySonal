/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import lk.sonal.gocheeta.server.Models.Booking;

/**
 *
 * @author sonal
 */
public interface BookingDao {
    public boolean AddBookng(Booking booking);
    public Booking getDriversActiveBooking(int DriverID);
    public boolean updateBookingStatus (int bookingID,String status);
}
