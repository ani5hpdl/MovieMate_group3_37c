// ─────────────────────────────────────────────────────────────────────────────
// File: ResendServlet.java
// Package: Controller
// ─────────────────────────────────────────────────────────────────────────────

package Controller;

import Doa.UserDAO;
import Doa.VerificationTokenDAO;
import Model.UserRegisterModel;
import Model.VerificationToken;
import util.EmailUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@WebServlet("/resend")
public class ResendServlet extends HttpServlet {
    private final UserDAO userDao = new UserDAO();
    private final VerificationTokenDAO tokenDao = new VerificationTokenDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        if (email == null || email.isEmpty()) {
            response.setContentType("text/html");
            response.getWriter().write(
                "<h3>No email specified.</h3>" +
                "<p><a href=\"/signup.html\">Go back to signup</a></p>"
            );
            return;
        }

        try {
            UserRegisterModel user = userDao.findByEmail(email);
            if (user == null) {
                response.setContentType("text/html");
                response.getWriter().write(
                    "<h3>No account found for “" + email + "”.</h3>"
                );
                return;
            }

            if (user.isVerified()) {
                response.setContentType("text/html");
                response.getWriter().write(
                    "<h3>Your account is already verified.</h3>"
                );
                return;
            }

            // Invalidate any old tokens for that user
            tokenDao.deleteByUserId(user.getId());

            // Generate & save a new token
            String newToken = UUID.randomUUID().toString();
            LocalDateTime newExpiry = LocalDateTime.now().plusHours(24);
            VerificationToken vToken = new VerificationToken(newToken, user.getId(), newExpiry);
            tokenDao.saveToken(vToken);

            // Send the new verification email
            try {
                EmailUtil.sendVerificationEmail(email, newToken);
            } catch (MessagingException mex) {
                response.setContentType("text/html");
                response.getWriter().write(
                    "<h3>Failed to send verification email.</h3>" +
                    "<p>Error: " + mex.getMessage() + "</p>"
                );
                return;
            }

            // Confirmation page
            response.setContentType("text/html");
            response.getWriter().write(
                "<h3>A new verification link has been sent to “" + email + "”.</h3>" +
                "<p>Please check your inbox (and spam folder).</p>"
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().write(
                "<h3>An unexpected error occurred while resending verification.</h3>"
            );
        }
    }
}
