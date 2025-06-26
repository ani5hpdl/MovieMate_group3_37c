/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.movieDetails;
import Dao.MovieDetails; 
import view.MovieDetails;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.Arrays;
import util.Arrays;
import java.util.List;

public clas MovieDetailsController{

private final MovieDetailDao movieDao  = new MovieDeatilDao();
private final MovieDetailView movieview;

public MovieDeatilController (MovieDeatilView movieView){
this.movieview = movieView;
this.movieview.addSaveMovieListener (new SaveMovieListner());
}

    public static void main(String[] args) {
        MovieDetailView view = new MovieDetailView(); // You must have implemented this view
        MovieDetailsController controller = new MovieDetailsController(view);
        controller.open();
    }


public void open(){
 this.movieView.setVisible(true);

}
public void close(){
this.movie.view.dispose();
  
}
class SaveMovieListener implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
 try {
      String title = movieView.getTitleField().getText().trim();
      int duration = Integer.parseInt(movieView.getDurationField().getText().trim());
      String director = movieView.getDirectorField().getText().trim();
      double rating = Double.parseDouble(movieView.getratingFiels().getText().trim());
      List<String> genres = Array.asList(movieView.getGenresArea().getText().split(","));
      String synopsis = movieView.getSynopsisArea().getText().trim();
      List<String> cast = Arrays.asList(movieView.getCastArea().getText().split(","));
      List<String> photos = Arrays.asList(movieView.getPhotoArea().getText().split(","));
      
     MovieDetails movie = new MovieDetails(title, duration, director, rating, genres, synopsis, cast, photos);
     
     boolean exists = movieDao.checkMovieExists(movie.getTitle());
     if (exists){
          JOptionpane.showMessageDialog(movieView, "Duplicate movie title", "Error", JOptionpane.ERROR_MESSAGE);
          }else {
             movieDao.saveMovie(movie);
             JOptionpane.showMessageDialog(movieView,"Movie saved successfully !");
            }
        }catch(NumberFormatException ex){
           JOptionpane.showMessageDialog(movieView, "Please enter valid numeric values for duration and rating","Input Error", JOptionpane. ERROR_MESSAGE);
        } catch (Exception ex){
          system.out.println("Error saving movie:" + ex.getMessage());
}
}
}


/**
 *
 * @author lenovo
 */

    

