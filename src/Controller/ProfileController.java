/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.ProfileDao;
import Model.Profile;
import view.ProfileView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileController {

    private final ProfileDao profileDao = new ProfileDao();
    private final ProfileView profileView;
    private Profile currentProfile;

    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;

        profileView.addUpdateListener(new UpdateProfileListener());

        loadProfile();
    }

    private void loadProfile() {
        currentProfile = profileDao.getProfile();
        if (currentProfile != null) {
            profileView.getfullname().setText(currentProfile.getFullName());
            profileView.getEmail().setText(currentProfile.getEmail());
            profileView.getNumber().setText(currentProfile.getPhoneNumber());
            profileView.getAddress().setText(currentProfile.getAddress());
        }
    }

    class UpdateProfileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String fullName = profileView.getfullname().getText();
                String email = profileView.getEmail().getText();
                String phone = profileView.getNumber().getText();
                String address = profileView.getAddress().getText();

                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(profileView, "Invalid email format");
                    return;
                }
                if (!isValidPhone(phone)) {
                    JOptionPane.showMessageDialog(profileView, "Invalid phone format");
                    return;
                }

                currentProfile.setFullName(fullName);
                currentProfile.setEmail(email);
                currentProfile.setPhoneNumber(phone);
                currentProfile.setAddress(address);

                profileDao.updateProfile(currentProfile);
                JOptionPane.showMessageDialog(profileView, "Profile updated successfully");

                // If email or password changed, simulate re-verification
                if (!email.equals(currentProfile.getEmail())) {
                    JOptionPane.showMessageDialog(profileView, "Please verify your new email.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(profileView, "Error updating profile: " + ex.getMessage());
            }
        }
    }

    // Basic validators
    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}"); // Example: 10 digits only
    }
}




