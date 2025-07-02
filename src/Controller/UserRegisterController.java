package Controller;

import Doa.VerificationTokenDAO;
import Model.VerificationToken;
import util.EmailUtil;
import view.Emailverification;
import view.UserRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class UserRegisterController {

    private UserRegister registerForm;

    public UserRegisterController(UserRegister registerForm) {
        this.registerForm = registerForm;

        // Handle register button
        registerForm.addAdduserListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegistration();
            }
        });

        // Handle login redirect
        registerForm.addLoginHereListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle login navigation if needed
            }
        });
    }

    private void handleRegistration() {
        String name = registerForm.getnameField().getText().trim();
        String email = registerForm.getemailField().getText().trim();
        String address = registerForm.getaddressField().getText().trim();
        String contact = registerForm.getnumberField().getText().trim();
        String password = String.valueOf(registerForm.getpasswordField().getPassword()).trim();

        // Generate 6-digit OTP
        String otp = String.valueOf(100000 + new Random().nextInt(900000));

        VerificationToken token = new VerificationToken();
        token.setFullName(name);
        token.setEmail(email);
        token.setAddress(address);
        token.setContactNumber(contact);
        token.setPassword(password);  // Optional: hash this
        token.setOtp(otp);
        token.setOtpCreatedAt(new Date());

        boolean success = VerificationTokenDAO.saveTempUser(token);
        if (success) {
            try {
                EmailUtil.sendOtpEmail(email, otp);  // Send OTP
                System.out.println("OTP sent to: " + email);

                // Show OTP screen
                Emailverification otpForm = new Emailverification(email);
                otpForm.setVisible(true);

                registerForm.dispose();   // close the register form
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Failed to register user");
        }
    }
}
