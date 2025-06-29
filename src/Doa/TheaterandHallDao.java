/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Database.MySqlConnection;
import Model.MovieSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author anish
 */
public class TheaterandHallDao {
    MySqlConnection mysql = new MySqlConnection();
    
    public int getShowTime(){
        Connection conn = mysql.openConnection();
        String sql = "SELECT showtime FROM moviedata WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,MovieSession.getMovieId());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                String showtimeStr = result.getString("showtime");
                return Integer.parseInt(showtimeStr.replace(":", ""));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return 0;
    }
}
