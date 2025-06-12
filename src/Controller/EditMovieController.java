/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.MovieDao;
import Model.MovieData;
import Model.UserSession;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import view.AdminPanel;
import view.AdminPannel3;

/**
 *
 * @author anish
 */
public class EditMovieController {
    public final MovieDao movie = new MovieDao();
    private final AdminPannel3 editmovie;
//    public movieid =1 ;
    
    public EditMovieController(AdminPannel3 editmovie){
        this.editmovie = editmovie;
        editmovie.addUpdateMovieListener(new UpdateMovieListener());
        editmovie.addCancelMovieListener(new CancelMovieListener());
        
        loadEditMovie(1);
        
//        addmovie.addImageListener(new AddImageListener());
//        addmovie.addMoreImageListener(new MoreImageListener());
        
        editmovie.getMainImageButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFileChooser1();

            }
        });
        
        editmovie.getMoreImageButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFileChooser2();

            }
        });
    }
    public void open(){
        this.editmovie.setVisible(true);
    }
    public void close(){
        this.editmovie.dispose();
    }
    
    public MovieData fetchMovie(int movieid){
        return movie.getMovieById(movieid);
    }
    class CancelMovieListener implements ActionListener{
 
        @Override
        public void actionPerformed(ActionEvent e) {
            editmovie.dispose();
            editmovie.setVisible(false);
        }
        
    }
    
    class UpdateMovieListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MovieDao moviedao = new MovieDao();
            try{
                String title = editmovie.getMovieNameField().getText();
                String director = editmovie.getDirectorField().getText();
                String cast = editmovie.getCastField().getText();
                int duration = (Integer) editmovie.getDurationSpinner().getValue();
                String genre = (String) editmovie.getGenreComboBox().getSelectedItem();
                String language =(String) editmovie.getLanguageComboBox().getSelectedItem();
                String poster_path = editmovie.getMainImageButton().getText();
                String more_image_path = editmovie.getMoreImageButton().getText();
                int rating = (Integer) editmovie.getRatingSpinner().getValue();
                Date release_date = editmovie.getReleaseDatePicker().getDate();
                String showtime = (String) editmovie.getShowTimeComboBox().getSelectedItem();
                String synopsis = editmovie.getSynopsisField().getText();
                
                MovieData moviedata = new MovieData(title,director,cast,duration,genre,language,rating,synopsis,release_date,showtime,poster_path,more_image_path);
                
                boolean check = moviedao.updateMovieById(moviedata,1);
                    
                    if(check){
                        JOptionPane.showMessageDialog(null,"Data is Updating May take Few Moments!!");
                    }else{
                        JOptionPane.showMessageDialog(null,"Error while Updating Data Try Again !!");
                    }
                    
                    close();
                    
                    AdminPanel admin = new AdminPanel();
                    AdminPanelController controller = new AdminPanelController(admin);
                    controller.open();
                
            }catch(Exception ex){
                System.out.println("Error Updating Movie"+ ex.getMessage());

            }
        }
        
    }
    
    
    public void loadEditMovie(int movieid){
        MovieData data = this.fetchMovie(movieid);
        
        if(data != null){
            editmovie.getMovieNameField().setText(data.getTitle());
            editmovie.getDirectorField().setText(data.getDirector());
            editmovie.getCastField().setText(data.getCast());
            editmovie.getDurationSpinner().setValue(data.getDuration());
            editmovie.getGenreComboBox().setSelectedItem(data.getGenre());
            editmovie.getLanguageComboBox().setSelectedItem(data.getLanguage());
            editmovie.getMainImageButton().setText(data.getPosterPath());
            editmovie.getMoreImageButton().setText(data.getMoreImagePath());
            editmovie.getRatingSpinner().setValue(data.getRating());
            editmovie.getReleaseDatePicker().setDate(data.getReleaseDate());
            editmovie.getShowTimeComboBox().setSelectedItem(data.getShowTime());
            editmovie.getSynopsisField().setText(data.getSynopsis());
        }
    }
    
    private void openFileChooser1() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Select the image");

        int result = jFileChooser.showOpenDialog(editmovie);
        if (result == JFileChooser.APPROVE_OPTION) {
            String productImage = jFileChooser.getSelectedFile().getAbsolutePath();
            editmovie.getMainImageButton().setText(productImage);

        }
    }
    private void openFileChooser2() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Select the image");

        int result = jFileChooser.showOpenDialog(editmovie);
        if (result == JFileChooser.APPROVE_OPTION) {
            String productImage = jFileChooser.getSelectedFile().getAbsolutePath();
            editmovie.getMoreImageButton().setText(productImage);

        }
    }
}
