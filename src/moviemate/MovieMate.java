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
import Database.*;
import view.AdminPanel;
import view.AdminPannel2;
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
        

        UserRegister UserRegisterForm = new UserRegister();
        UserRegisterController controller = new UserRegisterController(UserRegisterForm);
        controller.open();
        

//        AdminPannel2 myprojform = new AdminPannel2();
//        myprojform.setVisible(true);
//        AddMovieController controller = new AddMovieController(myprojform);
//        controller.open();
        
        // AdminPanel adminpanel = new AdminPanel();
        // AdminPanelController controller =new AdminPanelController(adminpanel);
        // controller.open();

    }
}
