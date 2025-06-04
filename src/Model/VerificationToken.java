package Model;

// ─────────────────────────────────────────────────────────────────────────────
// File: VerificationToken.java
// Package: com.yourapp.model
// ─────────────────────────────────────────────────────────────────────────────


import java.time.LocalDateTime;

public class VerificationToken {
    private String token;
    private long userId;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;

    // No-arg constructor
    public VerificationToken() { }

    // Constructor without createdAt (for insertion)
    public VerificationToken(String token,
                             long userId,
                             LocalDateTime expiresAt) {
        this.token = token;
        this.userId = userId;
        this.expiresAt = expiresAt;
    }

    // Full constructor
    public VerificationToken(String token,
                             long userId,
                             LocalDateTime expiresAt,
                             LocalDateTime createdAt) {
        this.token = token;
        this.userId = userId;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
    }

    // ─── Getters and Setters ───────────────────────────────────────────────

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

