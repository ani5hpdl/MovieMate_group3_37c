/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Model.MovieData;
import Database.MySqlConnection;
import Model.ProfileModel;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author anish
 */
public class MovieDao {
    MySqlConnection mysql = new MySqlConnection();
    
    public void MovieDao(MovieData movie){
        Connection conn = mysql.openConnection();
        
        String sql = "INSERT INTO moviedata (title, director, cast, duration, genre, language, rating, synopsis, release_date, showtime, poster_path, more_image_path) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, movie.getTitle());
            pstm.setString(2, movie.getDirector());
            pstm.setString(3, movie.getCast());
            pstm.setInt(4, movie.getDuration());
            pstm.setString(5, movie.getGenre());
            pstm.setString(6, movie.getLanguage());
            pstm.setInt(7, (int) movie.getRating());
            pstm.setString(8, movie.getSynopsis());
            pstm.setDate(9, new Date(movie.getReleaseDate().getTime())); 
            pstm.setString(10, movie.getShowTime());
            pstm.setString(11, movie.getPosterPath());
            pstm.setString(12, movie.getMoreImagePath());
            pstm.executeUpdate();
        }catch(Exception ex){
            Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            mysql.closeConnection(conn);
        }
    }
    
    public MovieData getMovieById(int movieid){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM moviedata WHERE id = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, movieid);
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                return new MovieData(
                        result.getString("title"),
                        result.getString("director"),
                        result.getString("cast"),
                        result.getInt("duration"),
                        result.getString("genre"),
                        result.getString("language"),
                        result.getDouble("rating"),
                        result.getString("synopsis"),
                        result.getDate("release_date"),
                        result.getString("showtime"),
                        result.getString("poster_path"),
                        result.getString("more_image_path")
                );
            }
           conn.close(); 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public static String validate(MovieData movie) {
    if (movie.getTitle() == null || movie.getTitle().trim().isEmpty()) {
        return "Title is required";
    }
    if (movie.getDirector() == null || movie.getDirector().trim().isEmpty()) {
        return "Director is required";
    }
    if (movie.getCast() == null || movie.getCast().trim().isEmpty()) {
        return "Cast is required";
    }
    if (movie.getDuration() <= 0) {
        return "Duration must be a positive number";
    }
    if (movie.getGenre() == null || movie.getGenre().trim().isEmpty()) {
        return "Genre is required";
    }
    if (movie.getLanguage() == null || movie.getLanguage().trim().isEmpty()) {
        return "Language is required";
    }
    if (movie.getRating() < 0 || movie.getRating() > 10) {
        return "Rating must be between 0 and 10";
    }
    if (movie.getSynopsis() == null || movie.getSynopsis().trim().isEmpty()) {
        return "Synopsis is required";
    }
    if (movie.getReleaseDate() == null) {
        return "Release date is required";
    }
    if (movie.getShowTime() == null || movie.getShowTime().trim().isEmpty()) {
        return "Showtime is required";
    }

    return null; // No errors
}
    public List<MovieData> getAllMovies(){
        List<MovieData> movies = new ArrayList<>();
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM moviedata";
        
        try(PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet result = pstmt.executeQuery()){
            while(result.next()){
                MovieData moviedata = new MovieData(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("director"),
                        result.getString("cast"),
                        result.getInt("duration"),
                        result.getString("genre"),
                        result.getString("language"),
                        result.getInt("rating"),
                        result.getString("synopsis"),
                        result.getDate("release_date"),
                        result.getString("showtime"),
                        result.getString("poster_path"),
                        result.getString("more_image_path")
                );
                movies.add(moviedata);
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            mysql.closeConnection(conn);
        }
        return movies;
    }
    
    public boolean updateMovieById(MovieData moviedata,int movieid){
        Connection conn = mysql.openConnection();
        String sql = "UPDATE moviedata SET title = ?, director = ?, cast = ?, duration = ?, genre = ?, language = ?, rating = ?, synopsis = ?, release_date = ?, showtime = ?, poster_path = ?, more_image_path = ? WHERE id = ?";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, moviedata.getTitle());
            pstm.setString(2, moviedata.getDirector());
            pstm.setString(3, moviedata.getCast());
            pstm.setInt(4, moviedata.getDuration());
            pstm.setString(5, moviedata.getGenre());
            pstm.setString(6, moviedata.getLanguage());
            pstm.setInt(7, (int) moviedata.getRating());
            pstm.setString(8, moviedata.getSynopsis());
            pstm.setDate(9, new Date(moviedata.getReleaseDate().getTime())); 
            pstm.setString(10, moviedata.getShowTime());
            pstm.setString(11, moviedata.getPosterPath());
            pstm.setString(12, moviedata.getMoreImagePath());
            pstm.setInt(13, movieid);
            
            int rows = pstm.executeUpdate();
            return rows>0;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

}
