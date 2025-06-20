/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Model.UserRegisterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Database.MySqlConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author anish
 */
public class UserRegisterDao {
    MySqlConnection mysql = new MySqlConnection();
    
    public void UserRegisterDao(UserRegisterModel user){
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO user (fullname,email,contact_number,address,password) VALUES (?,?,?,?,?)";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1,user.getFullName());
            pstm.setString(2,user.getEmail());
            pstm.setInt(3,user.getContactNumber());
            pstm.setString(4, user.getAddress());
            pstm.setString(5, user.getNewPassword());
            pstm.executeUpdate();
        }catch(Exception ex){
            Logger.getLogger(UserRegisterDao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public boolean CheckUser(UserRegisterModel user){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getNewPassword());
            ResultSet result = pstm.executeQuery();
            return result.next();
        }catch(Exception e){
            Logger.getLogger(UserRegisterDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
