/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *
 * @author NITRO
 */

import java.util.Date;

public class ProfileModel {
    private String email;
    private String fullname;
    private String address;
    private String contactNumber;
    private String bio;
    private Date dob;
    private String workplace;
    private String country;
    private String city;

    public ProfileModel(String email, String fullname, String address, String contactNumber,
                        String bio, Date dob, String workplace, String country, String city) {
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.contactNumber = contactNumber;
        this.bio = bio;
        this.dob = dob;
        this.workplace = workplace;
        this.country = country;
        this.city = city;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
