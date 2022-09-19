/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.DataLayers;

import java.util.List;
import lk.sonal.gocheeta.server.Models.Branch;

/**
 *
 * @author sonal
 */
public interface BranchDao {
    public boolean addBranch(Branch branch);
    public List<Branch> getBranches();
    public boolean updateBranch(Branch branch);
    public boolean deleteBranch(int id);
    
}
