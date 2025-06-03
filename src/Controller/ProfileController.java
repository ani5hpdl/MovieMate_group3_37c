package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Doa.ProfileDao;
import Model.Profile;
import view.ProfileView;

public class ProfileController {

    private final ProfileDao profileDao = new ProfileDao();
    private final ProfileView profileView;

    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;

        profileView.addUpdateListener(new UpdateProfileListener());
    }

    public void open() {
        this.profileView.setVisible(true);
    }

    public void close() {
        this.profileView.dispose();
    }

    class UpdateProfileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String fullname = profileView.getfullname().getText();
                String email = profileView.getemail().getText();
                String phonenumber = profileView.getphonenumber().getText();
                String address = profileView.getaddress().getText();
                String password = profileView.getpassword().getText();
                if (fullname.isEmpty() || email.isEmpty() || phonenumber.isEmpty() || address.isEmpty()|| password.isEmpty()) {
                    profileView.showMessage("All fields must be filled.");
                    return;
                }

                Profile updatedProfile = new Profile(fullname, email, phonenumber, address,password);
                boolean success = profileDao.updateProfile(updatedProfile);

                if (success) {
                    profileView.showMessage("Profile updated successfully!");
                } else {
                    profileView.showMessage("Failed to update profile.");
                }

            } catch (Exception ex) {
                profileView.showMessage("Error: " + ex.getMessage());
            }
        }
    }
}
