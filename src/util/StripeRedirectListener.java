package util;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author anish
 */



public class StripeRedirectListener {

    public static void startServer() {
        try {
            HttpServer server = HttpServer.create(new java.net.InetSocketAddress(4242), 0);

            server.createContext("/success", (HttpExchange exchange) -> {
                String response = "<h1>Payment Successful! You can close this tab.</h1>";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

                // ✅ Notify user inside your app
                javax.swing.SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "Payment Successful!");
                });

                server.stop(1); // Stop server after handling
            });

            server.createContext("/cancel", (HttpExchange exchange) -> {
                String response = "<h1>Payment Cancelled.</h1>";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

                javax.swing.SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "Payment Cancelled.");
                });

                server.stop(1);
            });

            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

