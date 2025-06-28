/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviemate;
import Controller.LoginController;
import Controller.UserRegisterController;
import Database.*;
import view.UserLogin;
import view.UserRegister;

import Controller.AddMovieController;
import Controller.AdminPanelController;
import Controller.DashboardController;
import Controller.EditMovieController;
import Controller.ProfileController;
import Controller.ResetPasswordController;
import Controller.UserMngmtController;
import Database.*;
import view.AdminPanel;
import view.AdminPannel2;
import view.AdminPannel3;
import view.AdminUserr;
import view.MainProfile;
import view.ResetPassword;
import view.UpdateProfile;
import view.dashboard;

/**
 *
 * @author anish
 */
public class MovieMate {
    public static void main(String[] args) {
        Database db = (Database) new MySqlConnection();
        if(db.openConnection() != null){
            System.out.println("Database connected Sucessfully");
        }else{
            System.out.println("Failed to connect to database");
        }
//        

//        UserRegister UserRegisterForm = new UserRegister();
//        UserRegisterController controller = new UserRegisterController(UserRegisterForm);
//        controller.open();
        

//        AdminPannel2 myprojform = new AdminPannel2();
//        myprojform.setVisible(true);
//        AddMovieController controller = new AddMovieController(myprojform);
//        controller.open();
        
//        ResetPassword reset = new ResetPassword();
//        ResetPasswordController controller = new ResetPasswordController(reset);
//        controller.open();

//            UserLogin login = new UserLogin();
//            LoginController controller = new LoginController(login);
//            controller.open();
//        UpdateProfile profile = new UpdateProfile();
//////        MainProfile profile = new MainProfile();
//        ProfileController controller = new ProfileController(profile);
//        controller.open1();
//
//        AdminPanel admin = new AdminPanel();
//        AdminPanelController controller = new AdminPanelController(admin);
//        controller.open();

//        AdminPannel3 edit = new AdminPannel3();
//        EditMovieController controller = new EditMovieController(edit);
//        controller.open();

//        AdminUserr user = new AdminUserr();
//        UserMngmtController controller = new UserMngmtController(user);
//        controller.open();

            dashboard dash = new dashboard();
            DashboardController controller = new DashboardController(dash);
            controller.open();

    }
            
}
