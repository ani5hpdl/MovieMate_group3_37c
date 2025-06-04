/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviemate;
import Controller.ProfileController;
import view.ProfileView;


/**
 *
 * @author anish
 */
public class MovieMate {
  public static void main(String[] args) {
        ProfileView profileView = new ProfileView();
        ProfileController controller= new ProfileController( profileView);
        controller.open();
    }
}

