package Controller;

import Doa.TempUserDao;
import Doa.UserDao;
import Model.TempUser;

public class OtpVerifier {

  public static String verifyOtp(String email, String otp) {
    try {
        TempUserDao tempUserDao = new TempUserDao();
        UserDao userDao = new UserDao();

        TempUser tempUser = tempUserDao.getTempUserByEmail(email);

        if (tempUser == null) {
            System.out.println("No temp user found for email: " + email);
            return "No pending registration found for this email.";
        }

        System.out.println("Stored OTP: '" + tempUser.getOtp() + "' | Entered OTP: '" + otp + "'");

        if (!tempUser.getOtp().trim().equalsIgnoreCase(otp.trim())) {
            return "Invalid OTP. Please try again.";
        }

        // Save verified user in final user table
        boolean saved = userDao.save(tempUser.toUser());

        if (saved) {
            tempUserDao.deleteTempUserByEmail(email);
            return "Registration successful!";
        } else {
            return "Error saving user data.";
        }
    } catch (Exception e) {
        e.printStackTrace();
        return "Error verifying OTP: " + e.getMessage();
    }
}
}
