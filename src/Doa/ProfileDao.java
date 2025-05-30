/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;
import Model.Profile;
import database.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NITRO
 */
public class ProfileDao {
    MySqlConnection mysql = new MySqlConnection();
    
     public boolean updateProfile(Profile profile) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE users SET full_name = ?, phone_number = ? WHERE email = ? WHERE address = ?";

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

    public Profile getProfileByEmail(String email) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT full_name, email, phone_number, address FROM users WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Profile(
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("address")

                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserdetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return null;
    }

    public boolean profileExists(String email) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT email FROM users WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserdetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return false;
    }


    public boolean deleteProfile(String email) {
        Connection conn = mysql.openConnection();
        String sql = "DELETE FROM users WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            int deletedRows = pstmt.executeUpdate();
            return deletedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserdetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return false;
    }
}


