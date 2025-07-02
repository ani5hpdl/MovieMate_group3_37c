package Model;

import java.util.Date;

public class VerificationToken {
    private String fullName;
    private String email;
    private String address;
    private String contactNumber;
    private String password;
    private String otp;
    private Date otpCreatedAt;

    // Empty constructor (optional)
    public VerificationToken() {
    }

    // Constructor with all fields (optional)
    public VerificationToken(String fullName, String email, String address, String contactNumber,
                             String password, String otp, Date otpCreatedAt) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.password = password;
        this.otp = otp;
        this.otpCreatedAt = otpCreatedAt;
    }

    // Getters and Setters

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Date getOtpCreatedAt() {
        return otpCreatedAt;
    }

    public void setOtpCreatedAt(Date otpCreatedAt) {
        this.otpCreatedAt = otpCreatedAt;
    }
}
