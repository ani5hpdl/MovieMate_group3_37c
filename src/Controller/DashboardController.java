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
import java.util.List;
import javax.swing.JPanel;
import view.DashboardCard;
import view.MovieCard;
import view.dashboard;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import view.bookinghistory;


/**
 *
 * @author anish
 */
public class DashboardController {
    private final dashboard view;
    private DashboardCard dashboardcrd;
    private String keyword;
    
    public DashboardController(dashboard view){
//        UserSession.setUserId(5);
        this.view = view;
        view.addSearchListener(new SearchListener());
        view.addHistoryListener(new HistoryListener());
        loadAllMovies(1);
    }
    public void open(){
        this.view.setVisible(true);
    }
    public void close(){
        this.view.dispose();
    }
    private void loadAllMovies(int ch) {
        MovieDao moviedao = new MovieDao();
        LocalDateTime now = LocalDateTime.now();
        Date currentDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        List<MovieData> movies;
        switch (ch) {
            case 1:
                movies = moviedao.getAllMovies();
                break;
            case 2:
                movies =moviedao.getMovies(keyword);
                break;
            default:
                System.out.println("Wrong");
                movies = null;
                break;
        }
        
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
    class SearchListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            liveSearch();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            liveSearch();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            liveSearch();
        }
        
        
        public void liveSearch(){
            keyword = view.getSearchField().getText().trim();
            if(keyword.isEmpty() || keyword.equals("Search")){
                System.out.println(" sdvvs");
                loadAllMovies(1);
            }else{
                loadAllMovies(2);
            }
        }
        
    }
    
    class HistoryListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            bookinghistory book = new bookinghistory();
            BookingHistoryController controller = new BookingHistoryController(book);
            controller.open();
        }
        
    }

}
