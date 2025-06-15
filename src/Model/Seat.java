
package Model;

/**
 *
 * @author ACER
 */
public class Seat {
    private String seatId;
    private String seatNumber;
    private String movieTitle;
    private String showtime;
    private String seatType;
    private String status;
    
    public Seat(String seatId, String seatNumber, String seatType, String status, String movieTitle, String showtime){
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.movieTitle = movieTitle;
        this.showtime = showtime;
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
    
public String getMovieTitle(){
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
        
    }
    
public String getShowtime(){
        return showtime;
    }
    public void setShowtime(String showtime){
        this.showtime = showtime;
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
