package Doa;

import Model.Seat;
import database.MySqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class SeatDao {
    MySqlConnection mysql = new MySqlConnection();

  
    public List<Seat> fetchSeatsForMovieAndShowtime(int movieId, int showTimeId) {
        Connection conn = mysql.openConnection();
        List<Seat> seatList = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE movie_id = ? AND showtime_id= ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, movieId);
            pst.setInt(2, showTimeId);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_number"),
                        rs.getInt("movie_id"),
                        rs.getInt("showtime_id"),
                        rs.getString("seat_type"),
                        rs.getString("status")
                );
                seatList.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return seatList;
    }

    
    public List<Seat> fetchSeatsByType(int movieId, int showTimeId, String seatType) {
        Connection conn = mysql.openConnection();
        List<Seat> seatList = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE movie_id = ? AND showtime_id = ? AND seat_type = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, movieId);
            pst.setInt(2, showTimeId); 
            pst.setString(3, seatType);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_number"),
                        rs.getInt("movie_id"),
                        rs.getInt("showtime_id"),
                        rs.getString("seat_type"),
                        rs.getString("status")
                );
                seatList.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return seatList;
    }

    
    public int countAvailableSeats(int movieId, int showTimeId) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT COUNT(*) AS availableSeats FROM seats WHERE movie_id = ? AND showtime_id = ? AND status = 'Available'";
        int count = 0;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, movieId);
            ps.setInt(2, showTimeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("availableSeats");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return count;
    }

    
    public Seat findSeatBySeatNum(String seatNum, int movieId, int showTimeId) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM seats WHERE seat_number = ? AND movie_id = ? AND showtime_id = ?";
        Seat seat = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, seatNum);
            ps.setInt(2, movieId);
            ps.setInt(3, showTimeId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_number"),
                        rs.getInt("movie_id"),
                        rs.getInt("showtime_id"),
                        rs.getString("seat_type"),
                        rs.getString("status")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return seat;
    }

    
    public boolean updateSeatBookingStatus(String seatId,int movieId, int showtimeId, boolean booked, String status) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE seats SET booked = ?, status = ? WHERE seat_id = ? AND movie_id = ? AND showtime_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, booked);
            ps.setString(2, status);
            ps.setString(3, seatId);
            ps.setInt(4, movieId);
            ps.setInt(5, showtimeId);
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return false;
    }
}
