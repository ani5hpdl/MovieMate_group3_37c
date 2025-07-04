/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;

import Model.PaymentModel;
import Database.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author it solution
 */
public class PaymentMethodDao {
    MySqlConnection mysql = new MySqlConnection();

    public boolean savePaymentInfo(PaymentModel payment) {
        Connection conn = mysql.openConnection();

        try {
            String query = "INSERT INTO payment (paymentMethod, accountNumber, consent, amount, totalTickets, seatNumbers, showTitle, transactionId, paymentStatus) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, payment.getPaymentMethod());
            stmt.setString(2, payment.getAccountNumber());
            stmt.setBoolean(3, payment.isConsent());
            stmt.setInt(4, payment.getAmount());
            stmt.setInt(5, payment.getTotalTickets());
            stmt.setString(6, payment.getSeatNumbers());
            stmt.setString(7, payment.getShowTitle());
            stmt.setString(8, payment.getTransactionId());
            stmt.setString(9, payment.getPaymentStatus());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePaymentStatus(PaymentModel payment) {
        Connection conn = mysql.openConnection();

        try {
            String query = "UPDATE payment SET transactionId = ?, paymentStatus = ? WHERE accountNumber = ? AND amount = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, payment.getTransactionId());
            stmt.setString(2, payment.getPaymentStatus());
            stmt.setString(3, payment.getAccountNumber());
            stmt.setInt(4, payment.getAmount());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


