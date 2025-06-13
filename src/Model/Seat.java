
package Model;

/**
 *
 * @author ACER
 */
public class Seat {
    private String seatId;
    private String seatNumber;
    private int movieId;
    private int showtimeId;
    private String seatType;
    private String status;
    
    public Seat(String seatId, String seatNumber, int movieId, int showtimeId, String seatType, String status){
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.movieId = movieId;
        this.showtimeId = showtimeId;
        this.seatType = seatType;
        this.status = status;
    }
    
    public String getSeatId(){
        return seatId;
    }
    public void setSeatId(String seatId){
        this.seatId = seatId;
    }
    
    public String getSeatNum(){
        return seatNumber;
    }
    public void setSeatNum(String seatNumber){
        this.seatNumber = seatNumber;
    }
    
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
    public int getShowtimeId(){
        return showtimeId;
    }
    public void setShowtimeId(int showtimeId){
        this.showtimeId = showtimeId;
    }
    
    public String getSeatType(){
        return seatType;
    }
    public void setSeatType(String seatType){
        this.seatType = seatType;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    @Override
    public String toString() {
        return seatNumber + " - " + seatType + " (" + status + ")";
    }

    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(status);
    }
}
