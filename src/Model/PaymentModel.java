/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author it solution
 */
public class PaymentModel {
    // Cart Info
    private String cartId;
    private int totalTickets;
    private List<String> seatNumbers;
    private double amountToBePaid;

    // Show Details
    private String movieName;
    private String location;
    private String hall;
    private String time;
    private String posterImagePath; // Path to the image

    // Personal Details
    private String customerName;
    private String email;
    private String phoneNumber;

    public PaymentModel( int totalTickets, List<String> seatNumbers, double amountToBePaid,
                        String movieName, String location, String hall, String time, String posterImagePath,
                        String customerName, String email, String phoneNumber) {
        this.totalTickets = totalTickets;
        this.seatNumbers = seatNumbers;
        this.amountToBePaid = amountToBePaid;

        this.movieName = movieName;
        this.location = location;
        this.hall = hall;
        this.time = time;
        this.posterImagePath = posterImagePath;

        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    // Getters and Setters
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public double getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(double amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosterImagePath() {
        return posterImagePath;
    }

    public void setPosterImagePath(String posterImagePath) {
        this.posterImagePath = posterImagePath;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


