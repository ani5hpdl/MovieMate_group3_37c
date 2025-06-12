
package Model;

/**
 *
 * @author ACER
 */
public class ShowTime {
    private int showtimeId;
    private int movieId;
    private String showtime;
    private int availableSeats;
    
     public ShowTime(int showtimeId,int movieId ,String showtime, int availableSeats){
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.showtime = showtime;
        this.availableSeats = availableSeats;
    }
     
    public int getShowtimeId(){
        return showtimeId;
    }
    public void setShowtimeId(int showtimeId){
        this.showtimeId = showtimeId;
    }
    
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
    public String getShowtime(){
        return showtime;
    }
    public void setShowtime(String showtime){
        this.showtime = showtime;
    }
    
    public int getAvailableSeats(){
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats){
        this.availableSeats = availableSeats;
    }
    
    @Override
    public String toString(){
        return showtime;
    }
            
}
