package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import Doa.ProfileDao;
import Doa.UserRegisterDao;
import Model.ProfileModel;
import Model.UserRegisterModel;
import Model.UserSession;
import java.util.Date;
import javax.swing.JOptionPane;
import view.MainProfile;
//import view.ProfileView;
import view.UpdateProfile;
import view.UserLogin;

public class ProfileController {

    private final ProfileDao profileDao = new ProfileDao();
    private  MainProfile profileView;
    private  UpdateProfile updateprofile;

    public ProfileController(MainProfile profileView) {
        this.profileView = profileView;
//        loadUserProfile(UserSession.getUserId());
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
            profileView.getcontactnumberField().setText(profile.getContactNumber());
            profileView.getfullnameField().setText(profile.getFullname());
            profileView.getfullname1Field().setText(profile.getFullname());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            profileView.getdobField().setText(sdf.format(profile.getDob()));
            profileView.getworkplaceField().setText(profile.getWorkplace());
            profileView.getcountryField().setText(profile.getCountry());
            profileView.getcityField().setText(profile.getCity());
            profileView.getbioField().setText(profile.getBio());
        }
    }
    public void loadEditUser(int userid){
        ProfileModel profile = this.fetchUserProfile(userid);
        
        if(profile != null){
            updateprofile.getaddressField().setText(profile.getAddress());
            updateprofile.getemailField().setText(profile.getEmail());
            updateprofile.getaddressField().setText(profile.getAddress());
            updateprofile.getcontactnumberField().setText(profile.getContactNumber());
            updateprofile.getfullnameField().setText(profile.getFullname());
        }
    }
    
    class UpdateUserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             ProfileDao profiledao = new ProfileDao();
            try{
                String FullName = updateprofile.getfullnameField().getText();
                String Address = updateprofile.getaddressField().getText();
                String Email = updateprofile.getemailField().getText();
                String contactnumber = updateprofile.getcontactnumberField().getText();
                String bio = updateprofile.getbioField().getText();
                String workplace = updateprofile.getworkplaceField().getText();
                String city = updateprofile.getcityField().getText();
                String country = updateprofile.getcountryField().getText();
                Date dob = updateprofile.getdobField().getDate();
                
                ProfileModel profile = new ProfileModel(Email,FullName,Address,contactnumber,bio,dob,workplace,country,city);
                if(!Email.contains("@")){
                    JOptionPane.showMessageDialog(updateprofile,"Enter a Valid Email");
                }
                else if(contactnumber.matches("^[789]\\dd{9}$")){
                    JOptionPane.showMessageDialog(updateprofile,"Enter Valid Phone Number");
                }
                else{
                    UserSession.setUserId(1);
                    boolean check = profiledao.updateUserById(profile,UserSession.getUserId());
                    
                    if(check){
                        JOptionPane.showMessageDialog(null,"Data is Updating May take Few Moments!!");
                    }else{
                        JOptionPane.showMessageDialog(null,"Error while Updating Data Try Again !!");
                    }
                    
                    close1();
                    

                    UserLogin UserLoginForm = new UserLogin();
                    LoginController controller = new LoginController(UserLoginForm);
                    controller.open();
                }
            }catch(Exception ex){
                System.out.println("Error Updating User"+ ex.getMessage());
            }
        }
        
    }
}
