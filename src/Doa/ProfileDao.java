/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Model.ProfileModel;
import Database.MySqlConnection;
import Model.UserSession;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileDao {
    MySqlConnection mysql = new MySqlConnection();
    
     
    public ProfileModel getUserById(int userid){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM user WHERE id = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, userid);
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                return new ProfileModel(
                        result.getString("email"),
                        result.getString("fullname"),
                        result.getString("address"),
                        result.getString("contact_number"),
                        result.getString("bio"),
                        result.getDate("dob"),
                        result.getString("workplace"),
                        result.getString("country"),
                        result.getString("city")
                );
            }
           conn.close(); 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public boolean updateUserById(ProfileModel profile){
        Connection conn = mysql.openConnection();
        String sql = "UPDATE user SET fullName = ?, email = ?, contact_number = ?, address = ?, country = ?, city = ?, bio = ?, dob = ?, workplace = ? WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,profile.getFullname());
            pstmt.setString(2,profile.getEmail());
            pstmt.setString(3,profile.getContactNumber());
            pstmt.setString(4,profile.getAddress());
            pstmt.setString(5,profile.getCountry());
            pstmt.setString(6,profile.getCity());
            pstmt.setString(7,profile.getBio());
            java.util.Date utilDate = profile.getDob();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstmt.setDate(8,sqlDate);
            pstmt.setString(9,profile.getWorkplace());
            pstmt.setInt(10, UserSession.getUserId());
            
            int rows = pstmt.executeUpdate();
            return rows>0;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
}

