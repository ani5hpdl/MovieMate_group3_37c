// ─────────────────────────────────────────────────────────────────────────────
// File: VerificationTokenDAO.java
// Package: DAO
// ─────────────────────────────────────────────────────────────────────────────

package Doa;

import Model.VerificationToken;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class VerificationTokenDAO {

    /**
     * Inserts a new token into 'verification_tokens'.
     */
    public void saveToken(VerificationToken tokenObj) throws SQLException {
        String sql = "INSERT INTO verification_tokens (token, user_id, expires_at) "
                   + "VALUES (?, ?, ?)";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tokenObj.getToken());
            stmt.setLong(2, tokenObj.getUserId());
            stmt.setTimestamp(3, Timestamp.valueOf(tokenObj.getExpiresAt()));
            stmt.executeUpdate();
        }
    }

    /**
     * Finds a VerificationToken by its token string. Returns null if not found.
     */
    public VerificationToken findByToken(String token) throws SQLException {
        String sql = "SELECT token, user_id, expires_at, created_at "
                   + "FROM verification_tokens WHERE token = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, token);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToToken(rs);
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * Deletes a token row (one‐time use).
     */
    public void deleteByToken(String token) throws SQLException {
        String sql = "DELETE FROM verification_tokens WHERE token = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, token);
            stmt.executeUpdate();
        }
    }

    /**
     * Deletes any existing tokens for the given user_id (used before issuing a new one).
     */
    public void deleteByUserId(long userId) throws SQLException {
        String sql = "DELETE FROM verification_tokens WHERE user_id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, userId);
            stmt.executeUpdate();
        }
    }

    /**
     * Helper to map a ResultSet row into a VerificationToken object.
     */
    private VerificationToken mapRowToToken(ResultSet rs) throws SQLException {
        String tokenString = rs.getString("token");
        long userId = rs.getLong("user_id");

        Timestamp expiryTs = rs.getTimestamp("expires_at");
        LocalDateTime expiresAt = expiryTs.toInstant()
                                          .atZone(ZoneId.systemDefault())
                                          .toLocalDateTime();

        Timestamp createdTs = rs.getTimestamp("created_at");
        LocalDateTime createdAt = createdTs.toInstant()
                                          .atZone(ZoneId.systemDefault())
                                          .toLocalDateTime();

        return new VerificationToken(
            tokenString,
            userId,
            expiresAt,
            createdAt
        );
    }
}
