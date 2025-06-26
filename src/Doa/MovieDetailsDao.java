/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;
import Database.MySqlConnection;
import Model.MovieData;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author it solution
 */
public class MovieDetailsDao {
   

    MySqlConnection mysql = new MySqlConnection();
    
    private String listToString(List<String> list) {
        return String.join(",", list);
    }

    
    private List<String> stringToList(String str) {
        return Arrays.asList(str.split("\\s*,\\s*"));
    }

    
    public boolean insertMovie(MovieDetails movie) {
        Connection conn = mysql.getConnection();

        String sql = "INSERT INTO moviedetails (title, duration, director, rating, genres, synopsis, cast, photos) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getDuration());
            ps.setString(3, movie.getDirector());
            ps.setDouble(4, movie.getRating());
            ps.setString(5, listToString(movie.getGenres()));
            ps.setString(6, movie.getSynopsis());
            ps.setString(7, listToString(movie.getCast()));
            ps.setString(8, listToString(movie.getPhotos()));

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(MovieDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }

    
    public List<MovieDetails> getAllMovies() {
        Connection conn = mysql.getConnection();
        List<MovieDetails> list = new ArrayList<>();
        String sql = "SELECT * FROM moviedetails";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MovieDetails movie = new MovieDetails();
                movie.setId(rs.getLong("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDuration(rs.getInt("duration"));
                movie.setDirector(rs.getString("director"));
                movie.setRating(rs.getDouble("rating"));
                movie.setGenres(stringToList(rs.getString("genres")));
                movie.setSynopsis(rs.getString("synopsis"));
                movie.setCast(stringToList(rs.getString("cast")));
                movie.setPhotos(stringToList(rs.getString("photos")));

                list.add(movie);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MovieDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return list;
    }

    
    public MovieDetails getMovieById(Long id) {
         Connection conn = mysql.getConnection();

        String sql = "SELECT * FROM moviedetails WHERE id = ?";
        MovieDetails movie = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                movie = new MovieDetails();
                movie.setId(rs.getLong("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDuration(rs.getInt("duration"));
                movie.setDirector(rs.getString("director"));
                movie.setRating(rs.getDouble("rating"));
                movie.setGenres(stringToList(rs.getString("genres")));
                movie.setSynopsis(rs.getString("synopsis"));
                movie.setCast(stringToList(rs.getString("cast")));
                movie.setPhotos(stringToList(rs.getString("photos")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MovieDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return movie;
    }

    
    public boolean deleteMovieById(Long id) {
        Connection conn = mysql.getConnection();
        String sql = "DELETE FROM moviedetails WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }

   
    public boolean updateMovie(MovieDetails movie) {
        Connection conn = mysql.getConnection();
        String sql = "UPDATE moviedetails SET title=?, duration=?, director=?, rating=?, genres=?, synopsis=?, cast=?, photos=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getDuration());
            ps.setString(3, movie.getDirector());
            ps.setDouble(4, movie.getRating());
            ps.setString(5, listToString(movie.getGenres()));
            ps.setString(6, movie.getSynopsis());
            ps.setString(7, listToString(movie.getCast()));
            ps.setString(8, listToString(movie.getPhotos()));
            ps.setLong(9, movie.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(MovieDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }
}


