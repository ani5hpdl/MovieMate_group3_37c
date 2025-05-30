
package Controller;
import Doa.UserDao;
import Model.OTP;
import Model.User;
import view.ResetPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import view.OTPEntry;

public class ResetPasswordController {
    private final UserDao userDao = new UserDao();
    private final ResetPassword resetView;

    public ResetPasswordController(ResetPassword resetView) {
        this.resetView = resetView;

        resetView.addUserListener(new SendCodeListener());
    }

    public void open() {
        resetView.setVisible(true);
    }

    public void close() {
        resetView.dispose();
    }

    class SendCodeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = resetView.gettextEmail().getText();

            if (email.isEmpty() || email.equals("Enter your email")) {
                JOptionPane.showMessageDialog(resetView, "Please enter your email.");
                return;
            }

            String otpCode = String.format("%06d", new Random().nextInt(999999));

            OTP otp = new OTP(email, otpCode);  

            boolean generateOTP = userDao.generateOTP(otp);
            if (generateOTP) {

                JOptionPane.showMessageDialog(resetView, "OTP sent to your email.");

                close();
                OTPEntry otpEntryView = new OTPEntry();
                OTPEntryController otpEntryController = new OTPEntryController(otpEntryView, userDao, email);
                otpEntryController.open();
            } else {
                JOptionPane.showMessageDialog(resetView, "Failed to send OTP. Please try again.");
            }
        }
    }
}    