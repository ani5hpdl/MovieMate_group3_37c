/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Userdetail;
import Doa.UserdetailDao;
import view.UserDetail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author NITRO
 */
public class UserDetailController {
   private UserDetail view;
    private UserdetailDao userDao;

    public UserDetailController(UserDetail view) {
        this.view = view;
        this.userDao = new UserdetailDao();

        initController();
    }

    private void initController() {
        view.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });
    }

    private void updateUser() {
        String username = view.getUsernameField().getText().trim();
        String email = view.getEmailField().getText().trim();
        String phone = view.getPhoneNumberField().getText().trim();

        if (username.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(view, "All fields must be filled!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Userdetail user = new Userdetail(username, email, phone);

        boolean success = userDao.updateUser(user);
        if (success) {
            JOptionPane.showMessageDialog(view, "Profile updated successfully!");
        } else {
            JOptionPane.showMessageDialog(view, "Failed to update profile!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


