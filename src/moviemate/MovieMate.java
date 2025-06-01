/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviemate;
import Controller.AddMovieController;
import Database.*;
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
        
        AdminPannel2 myprojform = new AdminPannel2();
        myprojform.setVisible(true);
        AddMovieController controller = new AddMovieController(myprojform);
        controller.open();
    }
}
