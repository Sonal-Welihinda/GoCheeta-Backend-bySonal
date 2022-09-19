/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.util.List;
import lk.sonal.gocheeta.server.Models.Location;

/**
 *
 * @author sonal
 */
public interface LocationDao {
    public boolean AddLocation(Location location);
    public List<Location> getLocations();
    public List<Location> getLocationsNames();
    public List<Location> getRelatedLocations(String location);
}
