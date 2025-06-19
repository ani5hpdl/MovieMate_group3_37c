/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author anish
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/send-otp")
public class OtpController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String email = request.getParameter("email");
        String otp = EmailUtility.sendOtp(email);
        if (otp != null) {
            OtpStore.store(email, otp);
            response.getWriter().write("OTP sent to: " + email);
        } else {
            response.getWriter().write("Error sending OTP.");
        }
    }
}
