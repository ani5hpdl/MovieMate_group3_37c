/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviemate;
import Controller.ProfileController;
import Doa.ProfileDao;
import view.ProfileView;
import Model.ProfileModel;

/**
 *
 * @author anish
 */
public class MovieMate {
  public static void main(String[] args) {
        ProfileView profileView = new ProfileView();
        ProfileModel profileModel = new ProfileModel();
        ProfileDao profileDao = new ProfileDao();
        ProfileController profileController= new ProfileController( profileView);
    }
}

