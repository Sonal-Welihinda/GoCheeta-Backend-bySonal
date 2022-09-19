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
    String ImageBase64;
    String CategoryName;
    boolean ImageUpdated;

    public VehicleCategory() {
    }

    public VehicleCategory(int categoryID, String ImageFileLocation, String ImageBase64, String CategoryName) {
        this.categoryID = categoryID;
        this.ImageFileLocation = ImageFileLocation;
        this.ImageBase64 = ImageBase64;
        this.CategoryName = CategoryName;
    }

    public String getImageBase64() {
        return ImageBase64;
    }

    public void setImageBase64(String ImageBase64) {
        this.ImageBase64 = ImageBase64;
    }

    public boolean isImageUpdated() {
        return ImageUpdated;
    }

    public void setImageUpdated(boolean ImageUpdated) {
        this.ImageUpdated = ImageUpdated;
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
