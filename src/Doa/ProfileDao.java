/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Model.ProfileModel;
import Database.MySqlConnection;

import java.sql.Connection;
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
                        result.getString("FullName"),
                        result.getString("Email"),
                        result.getString("ContactNumber"),
                        result.getString("Address"),
                        result.getString("password")
                );
            }
           conn.close(); 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public boolean updateUserById(ProfileModel profile,int userid){
        Connection conn = mysql.openConnection();
        String sql = "UPDATE user SET FullName = ?, Email = ?, ContactNumber = ?, Address = ?, Country = ?, City = ? WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,profile.getFullname());
            pstmt.setString(2,profile.getEmail());
            pstmt.setString(3,profile.getPhonenumber());
            pstmt.setString(4,profile.getAddress());
            pstmt.setString(5,profile.getCountry());
            pstmt.setString(6,profile.getCity());
            pstmt.setInt(7, userid);
            
            int rows = pstmt.executeUpdate();
            return rows>0;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
}

