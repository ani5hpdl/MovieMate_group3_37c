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
import java.net.*;

public class OtpSender {
    public static String sendOtp(String email) {
        try {
           URL url = new URL("http://localhost:8080/OtpApp/send-otp");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String postData = "email=" + URLEncoder.encode(email, "UTF-8");
            try (OutputStream os = conn.getOutputStream()) {
                os.write(postData.getBytes());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            return in.readLine();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
