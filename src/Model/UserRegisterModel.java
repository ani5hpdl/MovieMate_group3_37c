// ─────────────────────────────────────────────────────────────────────────────
// File: UserRegisterModel.java
// Package: Model
// ─────────────────────────────────────────────────────────────────────────────

package Model;

import java.time.LocalDateTime;

public class UserRegisterModel {
    private long id;
    private String fullName;
    private String email;
    private String address;
    private String contactNumber;
    private String passwordHash;
    private LocalDateTime createdAt;
    private boolean isVerified;

    // No‐arg constructor
    public UserRegisterModel() { }

    // Constructor for new user (before insertion – generated fields omitted)
    public UserRegisterModel(String fullName,
                             String email,
                             String address,
                             String contactNumber,
                             String passwordHash) {
        this.fullName       = fullName;
        this.email          = email;
        this.address        = address;
        this.contactNumber  = contactNumber;
        this.passwordHash   = passwordHash;
        this.isVerified     = false;               // default on signup
        this.createdAt      = LocalDateTime.now(); // can also be set by the database
    }

    // Full constructor (including all mapped columns)
    public UserRegisterModel(long id,
                             String fullName,
                             String email,
                             String address,
                             String contactNumber,
                             String passwordHash,
                             LocalDateTime createdAt,
                             boolean isVerified) {
        this.id             = id;
        this.fullName       = fullName;
        this.email          = email;
        this.address        = address;
        this.contactNumber  = contactNumber;
        this.passwordHash   = passwordHash;
        this.createdAt      = createdAt;
        this.isVerified     = isVerified;
    }

    // ─── Getters and Setters ───────────────────────────────────────────────

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isVerified() {
        return isVerified;
    }
    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
}

