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


/**
 *
 * @author anish
 */
public class MovieDao {
    MySqlConnection mysql = new MySqlConnection();
    
    public void MovieDao(MovieData movie){
        Connection conn = mysql.openConnection();
        
        String sql = "INSERT INTO moviedata (title,genre,language,rating,poster_path,more_image_path,showtime) VALUES (?,?,?,?,?,?,?)";
        
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, movie.getTitle());
            pstm.setString(2,movie.getGenre());
            pstm.setString(3, movie.getLanguage());
            pstm.setDouble(4, movie.getRating());
            pstm.setString(5, movie.getPosterPath());
            pstm.setString(6, movie.getMoreImagePath());
            pstm.setString(7, movie.getShowTime());
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
            if (movie.getGenre() == null || movie.getGenre().trim().isEmpty()) {
                return "Genre is required";
            }
            if (movie.getLanguage() == null || movie.getLanguage().trim().isEmpty()) {
                return "Language is required";
            }
            if (movie.getRating() < 0 || movie.getRating() > 10) {
                return "Rating must be between 0 and 10";
            }
            if (movie.getShowTime() == null || movie.getShowTime().trim().isEmpty()) {
                return "Showtime is required";
            }

            return null; // No error
    }
}
