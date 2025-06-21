/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Database.MySqlConnection;
import Model.UserMngmt;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author anish
 */
public class UsermngmtDao {
    MySqlConnection mysql = new MySqlConnection();

    public List<UserMngmt> getAllusers(){
        List<UserMngmt> users = new ArrayList<>();
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM user";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                UserMngmt u = new UserMngmt(
                    rs.getInt("id"),
                    rs.getString("fullname"),
                    rs.getDate("created_at"),
                    rs.getString("role"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("contact_number")
                );
                users.add(u);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return users;
    }

    public void deleteUser(int id) {
//        Connection conn = mysql.openConnection();
//        String sql = "Delete FROM user WHERE id = ?";
//        try(PreparedStatement pstm = conn.prepareStatement(sql)){
//            ResultSet rs = pstm.executeQuery();
//            
//        }
    }
}
