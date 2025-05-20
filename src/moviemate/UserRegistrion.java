/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;

public class UserRegistrion {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moviemate - Register");
        frame.setSize(1600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.RED);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        int panelWidth = 500;
        int panelHeight = 500;
        panel.setBounds((frame.getWidth() - panelWidth) / 2, (frame.getHeight() - panelHeight) / 2, panelWidth, panelHeight);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255, 150));
        frame.add(panel);

        JLabel logo = new JLabel("Moviemate", SwingConstants.CENTER);
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        logo.setForeground(Color.RED);
        logo.setBounds(175, 10, 150, 30);
        panel.add(logo);

        JLabel register = new JLabel("Register", SwingConstants.CENTER);
        register.setFont(new Font("Arial", Font.BOLD, 18));
        register.setBounds(200, 40, 100, 30);
        panel.add(register);

        String[] labels = {
            "Full name", "Email", "Address",
            "Contact number", "New password", "Re-enter password"
        };

        String[] placeholders = {
            "Enter your full name", "user name@gmail.com", "Enter your address",
            "Enter your contact number", "Enter a new password", "Re-enter password"
        };

        int y = 80;
        JTextField[] inputs = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setBounds(100, y, 300, 20);
            panel.add(lbl);

            if (labels[i].toLowerCase().contains("password")) {
                inputs[i] = new JPasswordField(placeholders[i]);
            } else {
                inputs[i] = new JTextField(placeholders[i]);
            }

            inputs[i].setBounds(100, y + 20, 300, 25);
            panel.add(inputs[i]);
            y += 60;
        }

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(100, y, 300, 30);
        registerBtn.setBackground(Color.RED);
        registerBtn.setForeground(Color.WHITE);
        panel.add(registerBtn);

        JLabel or = new JLabel("or continue with", SwingConstants.CENTER);
        or.setBounds(100, y + 40, 300, 20);
        panel.add(or);

        JButton google = new JButton("G");
        google.setBounds(140, y + 70, 50, 30);
        panel.add(google);

        JButton apple = new JButton("");
        apple.setBounds(225, y + 70, 50, 30);
        panel.add(apple);

        JButton facebook = new JButton("f");
        facebook.setBounds(310, y + 70, 50, 30);
        panel.add(facebook);

        JLabel footer = new JLabel("Don't have account yet? Register for free", SwingConstants.CENTER);
        footer.setBounds(100, y + 110, 300, 20);
        footer.setFont(new Font("Arial", Font.PLAIN, 10));
        panel.add(footer);

        frame.setVisible(true);
    }
}
