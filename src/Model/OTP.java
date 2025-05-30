package Model;

public class OTP {
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    private String code;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public OTP(String email, String code){
        this.email = email;
        this.code = code;
    }
}
