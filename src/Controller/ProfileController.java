package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Doa.ProfileDao;
import Model.ProfileModel;
import view.MainProfile;
import view.ProfileView;
import view.UpdateProfile;

public class ProfileController {

    private final ProfileDao profileDao = new ProfileDao();
    private  MainProfile profileView;
    private  UpdateProfile updateprofile;

    public ProfileController(MainProfile profileView) {
        this.profileView = profileView;
        loadUserProfile(1);
    }
    public ProfileController(UpdateProfile updateprofile) {
        this.updateprofile = updateprofile;
        loadEditUser(1);
        updateprofile.addUpdateUserListener(new UpdateUserListener());
    }

    public void open() {
        this.profileView.setVisible(true);
        
    }
    public void open1() {
        this.updateprofile.setVisible(true);
        
    }

    public void close() {
        this.profileView.dispose();
    }
     public void close1() {
        this.updateprofile.dispose();
    }

    public ProfileModel fetchUserProfile(int userid){
        return profileDao.getUserById(userid);
    }
    public static void main(String[] args) {
        System.out.println("Here");
    }
    public void loadUserProfile(int userid){
//        ProfileController controller = new ProfileController(profileView);
        ProfileModel profile = this.fetchUserProfile(userid);
        
        if(profile != null){
            profileView.getaddressField().setText(profile.getAddress());
            profileView.getemailField().setText(profile.getEmail());
            profileView.getaddressField().setText(profile.getAddress());
            profileView.getcontactnumberField().setText(profile.getPhonenumber());
            profileView.getfullnameField().setText(profile.getFullname());
        }
    }
    public void loadEditUser(int userid){
        ProfileModel profile = this.fetchUserProfile(userid);
        
        if(profile != null){
            updateprofile.getaddressField().setText(profile.getAddress());
            updateprofile.getemailField().setText(profile.getEmail());
            updateprofile.getaddressField().setText(profile.getAddress());
            updateprofile.getcontactnumberField().setText(profile.getPhonenumber());
            updateprofile.getfullnameField().setText(profile.getFullname());
        }
    }
    
    class UpdateUserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
}
