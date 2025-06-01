/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;
import Model.Profile;
import database.MySqlConnection;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NITRO
 */
public class ProfileDao {
    MySqlConnection mysql = new MySqlConnection();
    
    public Profile getProfile() {
    Profile profile = null;

    try (Connection conn = mysql.openConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM profiles WHERE id = ?")) {
        
        stmt.setInt(1, 1); // Replace with the actual user's ID or logic
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            profile = new Profile(
                rs.getString("full_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getString("address")
            );
        }

    } catch (SQLException ex) {
    }
    return profile;
}

     public boolean updateProfile(Profile profile) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE users SET fullname = ?, phonenumber = ? WHERE email = ? WHERE address = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, profile.getFullName());
            pstmt.setString(2, profile.getPhoneNumber());
            pstmt.setString(3, profile.getEmail());
            pstmt.setString(4, profile.getAddress());

            int updatedRows = pstmt.executeUpdate();
            return updatedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserdetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
}


