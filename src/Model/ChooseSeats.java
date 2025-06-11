/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author NITRO
 */
public class ChooseSeats {
      private int id;
    private String seatNumber;
    private boolean isBooked;
    private boolean isBlocked;
    
        public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    public boolean isBlocked() {
        return isBlocked;
    }
    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}

