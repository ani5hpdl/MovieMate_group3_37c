/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Database.MySqlConnection;
import Model.VerificationToken;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class VerificationTokenDAO {
    public static boolean saveTempUser(VerificationToken token) {
        try {
            Connection conn = new MySqlConnection().openConnection();
            String query = "INSERT INTO temp_users (full_name, email, address, contact_number, password, otp, otp_created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, token.getFullName());
            stmt.setString(2, token.getEmail());
            stmt.setString(3, token.getAddress());
            stmt.setString(4, token.getContactNumber());
            stmt.setString(5, token.getPassword());
            stmt.setString(6, token.getOtp());

            // Format timestamp
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            stmt.setString(7, sdf.format(token.getOtpCreatedAt()));

            int rows = stmt.executeUpdate();
            conn.close();
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error saving temp user: " + e);
            return false;
        }
    }
}
