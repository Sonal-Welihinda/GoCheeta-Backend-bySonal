/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.util.List;
import lk.sonal.gocheeta.server.VehicleCategory;

/**
 *
 * @author sonal
 */
public interface VehicleCategoryDao {
    public boolean addVCategory(VehicleCategory VCategory);
    public boolean updateVCategory(VehicleCategory VCategory);
    public List<VehicleCategory> getCategories();
    
}
