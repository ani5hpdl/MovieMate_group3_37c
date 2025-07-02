package Doa;

import Model.TempUser;
import Database.MySqlConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TempUserDao {
    MySqlConnection mysql = new MySqlConnection();

    // Check if email is already registered in users table
    public boolean isEmailRegistered(String email) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT 1 FROM users WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TempUserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    // Update only OTP (reuse old record for that email)
    public boolean updateOtpByEmail(String email, String otp) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE temp_users SET otp = ?, otp_created_at = NOW() WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, otp);
            ps.setString(2, email);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TempUserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    // Save a new temp user
    public boolean saveTempUser(TempUser tempUser) {
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO temp_users (full_name, email, address, contact_number, password, otp, otp_created_at) VALUES (?, ?, ?, ?, ?, ?, NOW())";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tempUser.getFullName());
            ps.setString(2, tempUser.getEmail());
            ps.setString(3, tempUser.getAddress());
            ps.setString(4, tempUser.getContactNumber());
            ps.setString(5, tempUser.getPassword());
            ps.setString(6, tempUser.getOtp());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TempUserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    public TempUser getTempUserByEmail(String email) {
    System.out.println("Fetching TempUser for email: " + email);
    Connection conn = mysql.openConnection();
    String sql = "SELECT * FROM temp_users WHERE email = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("OTP from DB: " + rs.getString("otp"));
            return new TempUser(
                rs.getString("full_name"),
                rs.getString("email"),
                rs.getString("address"),
                rs.getString("contact_number"),
                rs.getString("password"),
                rs.getString("otp")
            );
        } else {
            System.out.println("No temp user found for email: " + email);
        }
    } catch (SQLException ex) {
        Logger.getLogger(TempUserDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        mysql.closeConnection(conn);
    }
    return null;
}


    // Delete temp user
    public boolean deleteTempUserByEmail(String email) {
        Connection conn = mysql.openConnection();
        String sql = "DELETE FROM temp_users WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TempUserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
}
