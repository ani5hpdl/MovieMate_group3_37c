
package Doa;

import Model.Movie;
import database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class MovieDao {
    MySqlConnection mysql = new MySqlConnection();
    
    public List<Movie> getAllMovies(int movieId, String movieTitle){
        Connection conn = mysql.openConnection();
        List<Movie> movieList = new ArrayList<>();
        String sql = "SELECT movie_id, movie_title FROM movies";
        
        try(PreparedStatement pst = conn.prepareStatement(sql)){
           pst.setInt(1, movieId);
           pst.setString(2,movieTitle);
           
           ResultSet rs = pst.executeQuery();
           while (rs.next()){
               Movie movie = new Movie(
                    rs.getInt("movieId"),
                    rs.getString("movieTitle")
               );
               movieList.add(movie);
           }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return movieList;
    }
}
