/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import view.AdminPannel2;
import Doa.MovieDao;
import Model.MovieData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author anish
 */
public class AddMovieController {
    public final MovieDao movie = new MovieDao();
    private final AdminPannel2 addmovie;
    
    public AddMovieController(AdminPannel2 addmovie){
        this.addmovie = addmovie;
        addmovie.addAddMovieListener(new AddMovieListener());
        addmovie.addCancelMovieListener(new CancelMovieListener());
    }
    public void open(){
        this.addmovie.setVisible(true);
    }
    public void close(){
        this.addmovie.dispose();
    }
    
    class AddMovieListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MovieDao movieDao = new MovieDao();
            try{
                String title = addmovie.getMovieNameField().getText();
                String director = addmovie.getDirectorField().getText();
                String cast = addmovie.getCastField().getText();
                int duration = (int) addmovie.getDurationSpinner().getValue();
                String genre = (String) addmovie.getGenreComboBox().getSelectedItem();
                String language = (String) addmovie.getLanguageComboBox().getSelectedItem();
                double rating = (double) addmovie.getRatingSpinner().getValue();
                String synopsis = addmovie.getSynopsisField().getText();
                Date releaseDate = addmovie.getReleaseDatePicker().getDate();
                String showTime = (String) addmovie.getShowTimeComboBox().getSelectedItem();
                String posterPath = addmovie.getMainImageButton().getText();
                String moreImagePath = addmovie.getMoreImageButton().getText();

                // Create movie object
                MovieData movieData = new MovieData(title, director, cast, duration, genre, language,
                                                    rating, synopsis, releaseDate, showTime, posterPath, moreImagePath);

                // Validate input
                String check = MovieDao.validate(movieData);
                if (check == null) {
                    movieDao.MovieDao(movieData);
                    JOptionPane.showMessageDialog(addmovie, "Movie inserted successfully.");
                } else {
                    JOptionPane.showMessageDialog(addmovie, check);
                }

            }catch(Exception ex){
                System.out.println("Error Adding Movie"+ ex.getMessage());
            }
        }
        
    }
    class CancelMovieListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addmovie.dispose();
            addmovie.setVisible(false);
        }
        
    }
}
