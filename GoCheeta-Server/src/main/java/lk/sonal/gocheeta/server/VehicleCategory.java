/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

/**
 *
 * @author sonal
 */
public class VehicleCategory {
    
    private int categoryID;
    String ImageFileLocation;
    String CategoryName;

    public VehicleCategory() {
    }

    public VehicleCategory(int categoryID, String CategoryImg, String CategoryName) {
        this.categoryID = categoryID;
        this.ImageFileLocation = CategoryImg;
        this.CategoryName = CategoryName;
    }
    
    

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getImageFileLocation() {
        return ImageFileLocation;
    }

    public void setImageFileLocation(String ImageFileLocation) {
        this.ImageFileLocation = ImageFileLocation;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    
    
    
}
