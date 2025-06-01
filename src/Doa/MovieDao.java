/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Database.MySqlConnection;
import Model.MovieData;
import Database.MySqlConnection;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;


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
            pstm.setDouble(7, movie.getRating());
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

}
