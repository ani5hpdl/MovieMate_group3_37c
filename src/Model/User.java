package Model;

public class User {
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String contactNumber;

    public User(String email, String password, String fullName, String address, String contactNumber) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.contactNumber = contactNumber;
    }
    
    public User(String email, String password) {
    this.email = email;
    this.password = password;
}


    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}
