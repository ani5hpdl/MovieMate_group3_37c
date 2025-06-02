
package Controller;

import Doa.UserDao;
import Model.OTP;
import view.OTPEntry;
import view.NewPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

public class OTPEntryController {
    private final OTPEntry otpEntryView;
    private final UserDao userDao;
    private final String email;

    public OTPEntryController(OTPEntry otpEntryView, UserDao userDao, String email) {
        this.otpEntryView = otpEntryView;
        this.userDao = userDao;
        this.email = email;

        otpEntryView.addUserListener(new VerifyOtpListener());
    }

    public void open() {
        otpEntryView.setVisible(true);
    }

    public void close() {
        otpEntryView.dispose();
    }

    class VerifyOtpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredOtp = otpEntryView.getnumOtp().getText();

            if (enteredOtp.isEmpty() || enteredOtp.equals("Enter your OTP code")) {
                JOptionPane.showMessageDialog(otpEntryView, "Please enter the OTP.");
                return;
            }

            OTP otp = new OTP(email, enteredOtp);
            boolean verifyOTP = userDao.verifyOTP(otp);

            if (verifyOTP) {
                Timestamp createdAt = userDao.otpCreatedAt(otp);

                if (createdAt != null) {
                    long diff = System.currentTimeMillis() - createdAt.getTime();

                    if (diff <= 60 * 60 * 1000) { 
                        JOptionPane.showMessageDialog(otpEntryView, "OTP Verified!");

                        close();
                        NewPassword newPasswordView = new NewPassword();
                        NewPasswordController newPasswordController = new NewPasswordController(newPasswordView, userDao, email);
                        newPasswordController.open();

                    } else {
                        JOptionPane.showMessageDialog(otpEntryView, "OTP has expired. Please request a new one.");
                    }

                } else {
                    JOptionPane.showMessageDialog(otpEntryView, "Could not verify OTP creation time.");
                }

            } else {
                JOptionPane.showMessageDialog(otpEntryView, "Invalid OTP. Please try again.");
            }
        }
    
    }
 
    
    
}
