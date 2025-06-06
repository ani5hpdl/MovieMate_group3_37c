/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class Seat {
    private String seatId;
    public String getSeatId() {
        return seatId;
    }
    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
    private String seatType;
    public String getSeatType() {
        return seatType;
    }
    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
    private boolean booked;
    public boolean isBooked() {
        return booked;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    private int showTimeId;
    public int getShowTimeId() {
        return showTimeId;
    }
    public void setShowTimeId(int showTimeId) {
        this.showTimeId = showTimeId;
    }
    private int movieId;
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Seat(String seatId, String seatType, boolean booked, String status, int showTimeId, int movieId) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.booked = booked;
        this.status = status;
        this.showTimeId = showTimeId;
        this.movieId = movieId;
    }
}
