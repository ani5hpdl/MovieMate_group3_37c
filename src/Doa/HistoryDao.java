
package Doa;

import Model.BookingHistory;
import Database.MySqlConnection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class HistoryDao {
    
    MySqlConnection mysql = new MySqlConnection();
    
    public List<BookingHistory> getBookingHistory(int userId){
        Connection conn = mysql.openConnection();
        List<BookingHistory> bookingHistoryList = new ArrayList<>();
        String sql = "SELECT b.booking_id AS booking_id, " +
                     "       m.title AS title, " +
                     "       s.showtime AS showtime, " +
                     "       se.seat_number AS seat_number, " +
                     "       b.booked_datetime, " +
                     "       'Booked' AS status " +
                     "FROM booking b " +
                     "JOIN moviedata m ON b.movie_id = m.id " +
                     "JOIN seats se ON b.seat_id = se.seat_id " +
                     "JOIN showtimes s ON se.showtime_id = s.showtime_id " +
                     "WHERE b.user_id = ? " +
                     "ORDER BY b.booked_datetime DESC";
        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setInt(1, userId);
           
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               BookingHistory booking = new BookingHistory(
                       rs.getInt("booking_id"),
                       rs.getString("title"),
                       rs.getTimestamp("booked_datetime"),
                       rs.getString("seat_number"),
                       rs.getString("showtime"),
                       rs.getString("status")
               );
               bookingHistoryList.add(booking);
           }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return bookingHistoryList; 
    } 
    
    public List<BookingHistory> getBookingHistoryByMovie(int userId,String movieTitle) {
        Connection conn = mysql.openConnection();
        List<BookingHistory> bookingHistoryList = new ArrayList<>();
        String sql = "SELECT b.booking_id, m.title, s.seat_number, st.showtime, b.booked_datetime, 'Booked' AS status " +
                 "FROM booking b " +
                 "JOIN moviedata m ON b.movie_id = m.id " +
                 "JOIN seats s ON b.seat_id = s.seat_id " +
                 "JOIN showtimes st ON s.showtime_id = st.showtime_id " +
                 "WHERE b.user_id = ? AND m.title LIKE ? " +
                 "ORDER BY b.booked_datetime DESC";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setInt(1, userId);
             ps.setString(2, "%" + movieTitle + "%");  // Partial search

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BookingHistory booking = new BookingHistory(
                    rs.getInt("booking_id"),
                    rs.getString("title"),
                    rs.getTimestamp("booked_datetime"),
                    rs.getString("seat_number"),
                    rs.getString("showtime"),
                    rs.getString("status")
                );
                bookingHistoryList.add(booking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return bookingHistoryList;
    }

}
