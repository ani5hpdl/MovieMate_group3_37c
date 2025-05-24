/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anish
 */
public class UserRegisterModel {
    private int id;
    private String FullName;
    private String Email;
    private int ContactNumber; 
    private String Address;
    private String NewPassword;
    private String ConfirmPassword;
    
    public UserRegisterModel(String FullName, String Email, int ContactNumber, String Address, String NewPassword, String ConfirmPassword){
        this.FullName = FullName;
        this.Email = Email;
        this.ContactNumber = ContactNumber;
        this.Address = Address;
        this.NewPassword = NewPassword;
        this.ConfirmPassword = ConfirmPassword;
    }
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public int getContactNumber() {
        return ContactNumber;
    }
    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
    }
    
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }

    public String getNewPassword() {
        return NewPassword;
    }
    public void setNewPassword(String newPassword) {
        NewPassword = newPassword;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}
