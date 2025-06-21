/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.MovieDao;
import Model.MovieData;
import java.util.List;
import javax.swing.JPanel;
import view.DashboardCard;
import view.MovieCard;
import view.dashboard;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


/**
 *
 * @author anish
 */
public class DashboardController {
    private final dashboard view;
    private DashboardCard dashboardcrd;
    
    public DashboardController(dashboard view){
        this.view = view;
        loadAllMovies();
        
    }
    public void open(){
        this.view.setVisible(true);
    }
    public void close(){
        this.view.dispose();
    }
    private void loadAllMovies() {
        MovieDao moviedao = new MovieDao();
        LocalDateTime now = LocalDateTime.now();
        Date currentDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        List<MovieData> movies = moviedao.getAllMovies();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(currentDate);
        view.getTodayDate().setText(dateString);
        // Clear both panels
        JPanel releasedPanel = view.getMoviePanel();
        JPanel comingPanel = view.getComingPanel();

        releasedPanel.removeAll();
        comingPanel.removeAll();

        for (MovieData moviedata : movies) {
            DashboardCard card = new DashboardCard();
            card.setMovie(moviedata);

            if (moviedata.getReleaseDate().before(currentDate)) {
                releasedPanel.add(card); // Released movies
            } else {
                comingPanel.add(card); // Coming soon
            }
        }

        releasedPanel.revalidate();
        releasedPanel.repaint();

        comingPanel.revalidate();
        comingPanel.repaint();
    }

}
