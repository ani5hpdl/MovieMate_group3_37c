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
        addmovie.addAddMovieDataListener(new AddMovieDataListener());
    }
    public void open(){
        this.addmovie.setVisible(true);
    }
    public void close(){
        this.addmovie.dispose();
    }
    
    class AddMovieDataListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MovieDao movieDao = new MovieDao();
            try{
                String title = addmovie.getTitleField().getText();
                String genre = (String) addmovie.getGenreField().getSelectedItem();
                String language =(String) addmovie.getLanguageField().getSelectedItem();
                Double rating = Double.valueOf(addmovie.getRatingField().getText());
                String posterPath = addmovie.getPosterField().getText();
                String moreImagePath = addmovie.getMoreImageField().getText();
                String showTime = addmovie.getDateField().getText();
                MovieData moviedata = new MovieData(title,genre,language,rating,posterPath,moreImagePath,showTime);
                String check = MovieDao.validate(moviedata);
                if(check == null){
                    movieDao.MovieDao(moviedata);

                }else{
                    JOptionPane.showMessageDialog(addmovie,check);
                }
            }catch(Exception ex){
                System.out.println("Error Adding Movie"+ ex.getMessage());
            }
        }
        
    }
}
