
package Doa;

import Model.BookingHistory;
import database.MySqlConnection;
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
        String sql = "SELECT b.id AS booking_id, " +
                     "       m.title AS movie_title, " +
                     "       ms.showtime AS show_time, " +
                     "       seat.seat_number AS seat_number, " +
                     "       b.booked_datetime, " +
                     "       'Booked' AS status " +
                     "FROM booking b " +
                     "JOIN movie m ON b.movie_id = m.movie_id " +
                     "JOIN seat ON b.seat_id = seat.seat_id " +
                     "JOIN movie_show_time ms ON seat.showtime_id = ms.showtime_id " +
                     "WHERE b.user_id = ? " +
                     "ORDER BY b.booked_datetime DESC";
        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setInt(1, userId);
           
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               BookingHistory booking = new BookingHistory(
                       rs.getInt("booking_id"),
                       rs.getString("movie_title"),
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
}
