
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
    private String seatNum;
    private String status;
    private String showtime;


    public BookingHistory(int bookingId, String movieTitle, Date bookingDateTime, String seatNum, String status, String showtime) {
        this.bookingId = bookingId;
        this.movieTitle = movieTitle;
        this.bookingDateTime = bookingDateTime;
        this.seatNum = seatNum;
        this.status = status;
        this.showtime = showtime;
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

    public String getSeatNum() {
        return seatNum;
    }
    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getShowTime() {
        return showtime;
    }

    public void setShowTime(String showTime) {
        this.showtime = showTime;
    }
}
