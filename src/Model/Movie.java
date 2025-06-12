
package Model;

/**
 *
 * @author ACER
 */
public class Movie {
     private int movieId;
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
    private String movieTitle;
    public String getMovieTitle(){
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
        
    }
    
    public Movie(int movieId, String movieTitle){
        this.movieId = movieId;
        this.movieTitle = movieTitle;
    }
    
    @Override
    public String toString(){
        return movieTitle;
    }
   
}
