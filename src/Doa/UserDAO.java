// ─────────────────────────────────────────────────────────────────────────────
// File: UserDAO.java
// Package: DAO
// ─────────────────────────────────────────────────────────────────────────────

package Doa;

import Model.UserRegisterModel;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserDAO {

    /**
     * Inserts a new user into the 'users' table.Returns the generated user_id.
     * @param user
     * @return 
     * @throws java.sql.SQLException
     */
    public long create(UserRegisterModel user) throws SQLException {
        String sql = "INSERT INTO users "
                   + "(full_name, email, address, contact_number, password_hash, is_verified) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getAddress());
            stmt.setString(4, user.getContactNumber());
            stmt.setString(5, user.getPasswordHash());
            stmt.setBoolean(6, user.isVerified()); // false on signup

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long newId = generatedKeys.getLong(1);
                    user.setId(newId);
                    return newId;
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
    }

    /**
     * Finds a user by email.Returns null if not found.
     * @param email
     * @return 
     * @throws java.sql.SQLException
     */
    public UserRegisterModel findByEmail(String email) throws SQLException {
        String sql = "SELECT user_id, full_name, email, address, contact_number, password_hash, created_at, is_verified "
                   + "FROM users WHERE email = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToUser(rs);
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * Finds a user by their ID.Returns null if not found.
     * @param userId
     * @return 
     * @throws java.sql.SQLException
     */
    public UserRegisterModel findById(long userId) throws SQLException {
        String sql = "SELECT user_id, full_name, email, address, contact_number, password_hash, created_at, is_verified "
                   + "FROM users WHERE user_id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToUser(rs);
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * Sets is_verified = TRUE for the given user_id.
     * @param userId
     * @throws java.sql.SQLException
     */
    public void markAsVerified(long userId) throws SQLException {
        String sql = "UPDATE users SET is_verified = TRUE WHERE user_id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, userId);
            stmt.executeUpdate();
        }
    }

    /**
     * (Optional) Returns whether the given user_id is already verified.
     * @param userId
     * @return 
     * @throws java.sql.SQLException
     */
    public boolean isVerified(long userId) throws SQLException {
        String sql = "SELECT is_verified FROM users WHERE user_id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("is_verified");
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * Utility method to map a ResultSet row into a UserRegisterModel.
     */
    private UserRegisterModel mapRowToUser(ResultSet rs) throws SQLException {
        long id             = rs.getLong("user_id");
        String fullName     = rs.getString("full_name");
        String email        = rs.getString("email");
        String address      = rs.getString("address");
        String contact      = rs.getString("contact_number");
        String passwordHash = rs.getString("password_hash");

        Timestamp ts = rs.getTimestamp("created_at");
        LocalDateTime createdAt = ts.toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime();

        boolean isVerified = rs.getBoolean("is_verified");

        return new UserRegisterModel(
            id,
            fullName,
            email,
            address,
            contact,
            passwordHash,
            createdAt,
            isVerified
        );
    }
}
