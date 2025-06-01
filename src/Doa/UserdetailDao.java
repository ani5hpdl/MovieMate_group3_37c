/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;
import Model.Userdetail;
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
public class UserdetailDao {

    MySqlConnection mysql = new MySqlConnection();

    public boolean updateUser(Userdetail user) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE users SET username = ?, phone_number = ? WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPhoneNumber());
            pstmt.setString(3, user.getEmail());

            int updatedRows = pstmt.executeUpdate();
            return updatedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserdetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    public Userdetail getUserByEmail(String email) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT username, email, phone_number FROM users WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Userdetail(
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("phone_number")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserdetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }

        return null;
    }

    public boolean userExists(String email) {
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


    public boolean deleteUser(String email) {
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

