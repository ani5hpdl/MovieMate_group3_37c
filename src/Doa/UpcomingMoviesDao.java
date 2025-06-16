/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package Doa;

import Database.MySqlConnection;
import Model.UpcomingMovies;
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
 * @author User
 */
public class UpcomingMoviesDao{
    
    MySqlConnection mysql = new MySqlConnection();
    
    // Add new upcoming movie
    public void addComingSoon(UpcomingMovies cs) {
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO coming_soon (title, release_date, image_path, description, genre, cast, trailer_url) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,cs.getTitle());
            pstmt.setString(2,cs.getReleaseDate());
            pstmt.setString(3,cs.getImagePath());
            pstmt.setString(4,cs.getDescription());
            pstmt.setString(5,cs.getGenre());
            pstmt.setString(6,cs.getCast());
            
            pstmt.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(UpcomingMoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
    }

    // Get list of upcoming movies (today and future releases)
    public List<UpcomingMovies> getAllComingSoon() {
        List<UpcomingMovies> comingSoonList = new ArrayList<>();
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM coming_soon WHERE release_date >= CURDATE()";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
             ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                UpcomingMovies cs = new UpcomingMovies(
                    result.getString("title"),
                    result.getString("release_date"),
                    result.getString("image_path"),
                    result.getString("description"),
                    result.getString("genre"),
                    result.getString("cast")
                  );
                comingSoonList.add(cs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UpcomingMoviesDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return comingSoonList;
    }
}
