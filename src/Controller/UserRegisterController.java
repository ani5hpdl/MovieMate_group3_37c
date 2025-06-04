// ─────────────────────────────────────────────────────────────────────────────
// File: UserRegisterController.java
// Package: Controller
// ─────────────────────────────────────────────────────────────────────────────

package Controller;

import Doa.UserDAO;
import Doa.VerificationTokenDAO;
import Model.UserRegisterModel;
import Model.VerificationToken;
import util.EmailUtil;
import view.UserRegister;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserRegisterController {
    private final UserRegister view;
    private final UserDAO userDao;
    private final VerificationTokenDAO tokenDao;

    public UserRegisterController(UserRegister view) {
        this.view = view;
        this.userDao = new UserDAO();
        this.tokenDao = new VerificationTokenDAO();

        // Attach listener to the “Register” button (or whatever it’s called in your view)
        this.view.addAdduserListener(new AddUserListener());
    }

    public void open() {
        this.view.setVisible(true);
    }

    public void close() {
        this.view.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 1) Read fields from the Swing form
                String fullName        = view.getnameField().getText().trim();
                String email           = view.getemailField().getText().trim();
                String password        = new String(view.getpasswordField().getPassword());          // getPassword() if it's JPasswordField
                String confirmPassword = new String(view.getconfirmPasswordField().getPassword());   // assume view has a confirmPasswordField
                String address         = view.getaddressField().getText().trim();
                String contactNumber   = view.getnumberField().getText().trim();

                // 2) Basic validation
                if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() ||
                    confirmPassword.isEmpty() || address.isEmpty() || contactNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "All fields are required.", "Validation Error",
                                                  JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!email.contains("@") || !email.contains(".")) {
                    JOptionPane.showMessageDialog(view, "Enter a valid email address.", "Validation Error",
                                                  JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(view, "Passwords do not match.", "Validation Error",
                                                  JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 3) Check if the user already exists
                if (userDao.findByEmail(email) != null) {
                    JOptionPane.showMessageDialog(view, "A user with that email already exists.",
                                                  "Registration Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 4) Hash the password using BCrypt
                String hashedPassword = org.mindrot.jbcrypt.BCrypt.hashpw(password,
                                                    org.mindrot.jbcrypt.BCrypt.gensalt(12));

                // 5) Create a UserRegisterModel (isVerified defaults to false)
                UserRegisterModel newUser = new UserRegisterModel(
                    fullName,
                    email,
                    address,
                    contactNumber,
                    hashedPassword
                );

                // 6) Save the user to the database
                long userId = userDao.create(newUser);

                // 7) Generate a verification token (expires in 24 hours)
                String tokenString = UUID.randomUUID().toString();
                LocalDateTime expiresAt = LocalDateTime.now().plusHours(24);
                VerificationToken vToken = new VerificationToken(tokenString, userId, expiresAt);

                // 8) Save the token in the DB
                tokenDao.saveToken(vToken);

                // 9) Send verification email
                try {
                    EmailUtil.sendVerificationEmail(email, tokenString);
                } catch (MessagingException mex) {
                    // If email fails, optionally delete the user or inform them to retry
                    JOptionPane.showMessageDialog(view,
                        "Registration succeeded, but sending verification email failed:\n"
                        + mex.getMessage(),
                        "Email Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 10) Notify the user and clear the form (or close)
                JOptionPane.showMessageDialog(view,
                    "Registration successful!\nA verification link has been sent to your email.\n"
                    + "Please check your inbox and click the link to verify your account.",
                    "Registration Complete", JOptionPane.INFORMATION_MESSAGE);

                // Optionally clear form fields or close window:
                view.clearForm();  // implement this in your UserRegister view
                // or: close();

            } catch (NumberFormatException nfex) {
                JOptionPane.showMessageDialog(view, "Contact number must be numeric.",
                                              "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view,
                    "An unexpected error occurred:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}
