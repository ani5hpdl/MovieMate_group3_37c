// ─────────────────────────────────────────────────────────────────────────────
// File: VerifyServlet.java
// Package: Controller
// ─────────────────────────────────────────────────────────────────────────────

package Controller;

import Doa.UserDAO;
import Doa.VerificationTokenDAO;
import Model.VerificationToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet("/verify")
public class VerifyServlet extends HttpServlet {
    private final VerificationTokenDAO tokenDao = new VerificationTokenDAO();
    private final UserDAO userDao = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = request.getParameter("token");
        if (token == null || token.isEmpty()) {
            response.setContentType("text/html");
            response.getWriter().write("<h3>Invalid verification link.</h3>");
            return;
        }

        try {
            VerificationToken vToken = tokenDao.findByToken(token);
            if (vToken == null) {
                response.setContentType("text/html");
                response.getWriter().write("<h3>Invalid or already‐used verification link.</h3>");
                return;
            }

            // Check if expired
            if (vToken.getExpiresAt().isBefore(LocalDateTime.now())) {
                response.setContentType("text/html");
                response.getWriter().write(
                    "<h3>Your verification link has expired.</h3>" +
                    "<p><a href=\"resend?email="
                      + userDao.findByEmail(userDao.findById(vToken.getUserId()).getEmail()).getEmail()
                      + "\">Click here to resend a new verification email.</a></p>"
                );
                return;
            }

            // Mark user as verified
            userDao.markAsVerified(vToken.getUserId());
            // Delete the token so it cannot be reused
            tokenDao.deleteByToken(token);

            // Success page
            response.setContentType("text/html");
            response.getWriter().write(
                "<h3>Thank you! Your email has been verified.</h3>" +
                "<p><a href=\"/login.html\">Proceed to login</a></p>"
            );
        } catch (IOException | SQLException ex) {
            response.setContentType("text/html");
            response.getWriter().write("<h3>An error occurred during verification.</h3>");
        }
    }
}
