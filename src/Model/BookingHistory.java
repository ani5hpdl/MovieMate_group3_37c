
package Model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class BookingHistory {
    private int bookingId;
    private String movieTitle;
    private Date bookingDateTime;
    private int numberOfSeats;
    private String status;


    public BookingHistory(int bookingId, String movieTitle, Date bookingDateTime, int numberOfSeats, String status) {
        this.bookingId = bookingId;
        this.movieTitle = movieTitle;
        this.bookingDateTime = bookingDateTime;
        this.numberOfSeats = numberOfSeats;
        this.status = status;
    }

     public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getBookingDateTime() {
        return bookingDateTime;
    }
    public void setBookingDateTime(Date bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
