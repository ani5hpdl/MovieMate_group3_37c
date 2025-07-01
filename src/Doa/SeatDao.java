package Doa;

import Model.Seat;
import Database.MySqlConnection;

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

  
    public List<Seat> fetchSeatsForMovieAndShowtime(String movieTitle, String showtime) {
        Connection conn = mysql.openConnection();
        List<Seat> seatList = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE movie_title = ? AND showtime= ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, movieTitle);
            pst.setString(2, showtime);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_number"),
                        rs.getString("seat_type"),
                        rs.getString("status"),
                        rs.getString("movie_title"),
                        rs.getString("showtime")
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

    
    public List<Seat> fetchAllSeats(String movieTitle, String showtime) {
        Connection conn = mysql.openConnection();
        List<Seat> seatList = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE movie_title = ? AND showtime = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, movieTitle);
            pst.setString(2,showtime);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_number"),
                        rs.getString("seat_type"),
                        rs.getString("status"),
                        rs.getString("movie_title"),
                        rs.getString("showtime")
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

    
    public List<Seat> fetchSeatsByType(String movieTitle, String showtime, String seatType) {
        Connection conn = mysql.openConnection();
        List<Seat> seatList = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE movie_title = ? AND showtime = ? AND seat_type = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, movieTitle);
            pst.setString(2,showtime);
            pst.setString(3,seatType);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_number"),
                        rs.getString("seat_type"),
                        rs.getString("status"),
                        rs.getString("movie_title"),
                        rs.getString("showtime")
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

    
    public int countAllAvailableSeats(String movieTitle, String showtime) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT COUNT(*) AS availableSeats FROM seats WHERE movie_title = ? AND showtime = ? AND status = 'Available'";
        int count = 0;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movieTitle);
            ps.setString(2, showtime);
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

    
    public Seat findSeatBySeatNum(String movieTitle, String showtime, String seatNum) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM seats WHERE movie_title = ? AND showtime = ? AND seat_number = ?";
        Seat seat = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movieTitle);
            ps.setString(2, showtime);
            ps.setString(3, seatNum);
           

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_number"),
                        rs.getString("seat_type"),
                        rs.getString("status"),
                        rs.getString("movie_title"),
                        rs.getString("showtime")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return seat;
    }

    
    public boolean updateSeatBookingStatus(String movieTitle, String showtime, String seatNum, String status) {
        System.out.println("SeatDao: updateSeatBookingStatus method called");

        Connection conn = mysql.openConnection();
        String sql = "UPDATE seats SET status = ? WHERE movie_title = ? AND showtime =? AND seat_number = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setString(2, movieTitle);
            ps.setString(3, showtime);
            ps.setString(4, seatNum);

            System.out.println("Updating seat status:");
            System.out.println("Status = " + status);
            System.out.println("Seat Number = " + seatNum);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected by update: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return false;
    }

    public List<Seat> fetchSeatsByStatus(String movieTitle, String showtime, String Booked) {
        Connection conn = mysql.openConnection();
        List<Seat> seatList = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE movie_title = ? AND showtime = ? AND status = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movieTitle);
            ps.setString(2, showtime);
            ps.setString(3, Booked);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Seat seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_number"),
                        rs.getString("seat_type"),
                        rs.getString("status"),
                        rs.getString("movie_title"),
                        rs.getString("showtime")
                );
                seatList.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return seatList;
    }
    
    
   
    
}
