/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Model.ProfileModel;
import database.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileDao {
    MySqlConnection mysql = new MySqlConnection();

    public boolean updateProfile(ProfileModel profile) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE profiles SET fullname = ?, phonenumber = ?, address = ?, password = ?, WHERE email = ?";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, profile.getFullname());
            pstmt.setString(2, profile.getPhonenumber());
            pstmt.setString(3, profile.getAddress());
            pstmt.setString(4, profile.getEmail());
            pstmt.setString(5,profile.getPassword());

            int updatedRows = pstmt.executeUpdate();
            return updatedRows > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
}

