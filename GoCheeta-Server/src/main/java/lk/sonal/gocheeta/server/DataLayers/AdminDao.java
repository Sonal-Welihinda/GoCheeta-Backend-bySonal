/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.util.List;
import lk.sonal.gocheeta.server.Models.Admin;

/**
 *
 * @author sonal
 */
public interface AdminDao {
    public boolean addAdmin(Admin amin);
    public List<Admin> getAdmins();
    public List<Admin> getFilterAdmins(String branch,String accTYpe, String searchText);
    public boolean updateAdmin(Admin admin);
    public boolean deleteAdmin(int id);
}
