package Model;

public class TempUser {
    private String fullName;
    private String email;
    private String address;
    private String contactNumber;
    private String password;
    private String otp;

    public TempUser(String fullName, String email, String address, String contactNumber, String password, String otp) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.password = password;
        this.otp = otp;
    }

    // Getters & setters

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }

    // Convert TempUser to User
    public User toUser() {
        return new User(email, password, fullName, address, contactNumber);
    }
}
