// ─────────────────────────────────────────────────────────────────────────────
// File: EmailUtil.java
// Package: util
// ─────────────────────────────────────────────────────────────────────────────

package util;

import java.util.Properties;  
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {

    // ─── SMTP Configuration ────────────────────────────────────────────────────

    // Replace with your SMTP server’s details:
    private static final String SMTP_HOST     = "smtp.gmail.com";
    private static final String SMTP_PORT     = "587";
    private static final String SMTP_USERNAME = "your_smtp_username@gmail.com";
    private static final String SMTP_PASSWORD = "your_smtp_app_password";

    // “From” address shown in inbox
    private static final String FROM_EMAIL = "no-reply@yourdomain.com";
    private static final String FROM_NAME  = "YourAppName Team";

    // ─── Public Method to Send Verification Email ─────────────────────────────

    /**
     * Sends a plaintext verification email containing a one-time link.
     *
     * @param recipientEmail the user’s email address
     * @param token          the verification token to append to the link
     * @throws MessagingException if sending fails
     */
    public static void sendVerificationEmail(String recipientEmail, String token)
            throws MessagingException {

        // 1) Configure mail‐session properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        // 2) Build a Session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
            }
        });

        // 3) Construct the message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM_EMAIL, FROM_NAME));
        message.setRecipients(
            Message.RecipientType.TO,
            InternetAddress.parse(recipientEmail)
        );
        message.setSubject("Please Verify Your Email");

        // 4) Build the clickable verification link.
        //    Adjust host/port to match your deployed servlet path
        String verifyLink = "http://localhost:8080/verify?token=" + token;

        String emailBody = new StringBuilder()
            .append("Hello,\n\n")
            .append("Thank you for registering with YourAppName.\n")
            .append("To complete your registration, please click the link below:\n\n")
            .append(verifyLink)
            .append("\n\n")
            .append("This link will expire in 24 hours. If it does expire, you can request a new one ")
            .append("from the “Not verified” page.\n\n")
            .append("If you did not sign up, please ignore this email.\n\n")
            .append("Regards,\n")
            .append("YourAppName Team")
            .toString();

        message.setText(emailBody);

        // 5) Send the message
        Transport.send(message);
    }
}

