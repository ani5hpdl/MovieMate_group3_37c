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

    // Get all seats for a specific movie and showtime
    public List<Seat> fetchSeatsForMovieAndShowtime(int movieId, int showTimeId) {
        Connection conn = mysql.openConnection();
        List<Seat> seats = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE movie_id = ? AND showtime_id = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, movieId);
            pst.setInt(2, showTimeId);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_type"),
                        rs.getBoolean("booked"),
                        rs.getString("status"),
                        rs.getInt("showtime_id"),
                        rs.getInt("movie_id")
                );
                seats.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return seats;
    }

    // Get seats by type (e.g., regular/premium) for a movie and showtime
    public List<Seat> fetchSeatsByType(int movieId, int showTimeId, String seatType) {
        Connection conn = mysql.openConnection();
        List<Seat> seatList = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE movie_id = ? AND showtime_id = ? AND seat_type = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, movieId);
            pst.setInt(2, showTimeId); // Fixed: was using index 1 again
            pst.setString(3, seatType);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_type"),
                        rs.getBoolean("booked"),
                        rs.getString("status"),
                        rs.getInt("showtime_id"),
                        rs.getInt("movie_id")
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

    // Count available (unbooked) seats
    public int countAvailableSeats(int movieId, int showTimeId) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT COUNT(*) AS count FROM seats WHERE movie_id = ? AND showtime_id = ? AND booked = false";
        int count = 0;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, movieId);
            ps.setInt(2, showTimeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return count;
    }

    // Get a single seat by ID for movie and showtime
    public Seat findSeatById(String seatId, int movieId, int showTimeId) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM seats WHERE seat_id = ? AND movie_id = ? AND showtime_id = ?";
        Seat seat = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, seatId);
            ps.setInt(2, movieId);
            ps.setInt(3, showTimeId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                seat = new Seat(
                        rs.getString("seat_id"),
                        rs.getString("seat_type"),
                        rs.getBoolean("booked"),
                        rs.getString("status"),
                        rs.getInt("showtime_id"),
                        rs.getInt("movie_id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return seat;
    }

    // Update seat as booked/unbooked and set its visual status
    public boolean updateSeatBookingStatus(String seatId, boolean isBooked, String status) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE seats SET booked = ?, status = ? WHERE seat_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, isBooked);
            ps.setString(2, status);
            ps.setString(3, seatId);
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
