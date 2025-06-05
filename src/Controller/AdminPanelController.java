/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.MovieDao;
import Model.MovieData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import view.AdminPanel;
import view.AdminPannel2;
import view.MovieCard;

/**
 *
 * @author anish
 */
public class AdminPanelController {
    
    
    
    private final AdminPanel movie;
    
    public AdminPanelController(AdminPanel movie){
        this.movie = movie;
        System.out.println("Here");
        loadAllMovies();
        movie.addmovieListener(new MovieListener());
    }
    public void open(){
        this.movie.setVisible(true);
    }
    public void close(){
        this.movie.setVisible(false);
    }
    
    private void loadAllMovies(){
        MovieDao moviedao = new MovieDao();
        List<MovieData> movies = moviedao.getAllMovies();
        JPanel panel = movie.getMoviePanel();
        
        panel.removeAll();
        
        for(MovieData moviedata : movies){
            MovieCard card = new MovieCard();
            card.setMovie(moviedata);
            panel.add(card);
        }
        panel.revalidate();
        panel.repaint();
    }

    class MovieListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPannel2 adminpanel = new AdminPannel2();
            AddMovieController controller =new AddMovieController(adminpanel);
            
//            movie.setVisible(false);
            
            controller.open();

        }
        
    }
}
