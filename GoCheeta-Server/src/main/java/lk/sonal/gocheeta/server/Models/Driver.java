/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server.Models;

/**
 *
 * @author sonal
 */
public class Driver extends RegisterdPerson{
    int id;
    String Imgbase64;
    String ImgLocation;
    boolean ImgUpdated;
    int BranchID;
    String DOB;
    String username;
    String Status;

    public Driver() {
        
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgbase64() {
        return Imgbase64;
    }

    public void setImgbase64(String Imgbase64) {
        this.Imgbase64 = Imgbase64;
    }

    public String getImgLocation() {
        return ImgLocation;
    }

    public void setImgLocation(String ImgLocation) {
        this.ImgLocation = ImgLocation;
    }

    public boolean isImgUpdated() {
        return ImgUpdated;
    }

    public void setImgUpdated(boolean ImgUpdated) {
        this.ImgUpdated = ImgUpdated;
    }

    public int getBranchID() {
        return BranchID;
    }

    public void setBranchID(int BranchID) {
        this.BranchID = BranchID;
    }

    public String getContactNumber() {
        return PhoneNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.PhoneNumber = ContactNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }
    
    
    
    
}
