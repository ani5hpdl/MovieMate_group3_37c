/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviemate;
import Controller.ProfileController;
import Doa.ProfileDao;
import view.ProfileView;
import Model.Profile;

/**
 *
 * @author anish
 */
public class MovieMate {
  public static void main(String[] args) {
        ProfileView profileView = new ProfileView();
        Profile profile = new Profile();
        ProfileDao ProfileDao = new ProfileDao();
        ProfileController Controller= new ProfileController( profileView);
    }
}

