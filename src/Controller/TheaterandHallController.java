/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.TheaterandHallDao;
import Model.MovieSession;
import javax.swing.JButton;
import view.TheatersandHall;

/**
 *
 * @author anish
 */
public class TheaterandHallController {
    
    private TheatersandHall view;
    private final TheaterandHallDao dao = new TheaterandHallDao();
    public TheaterandHallController(TheatersandHall view){
        this.view = view;
//        MovieSession.setMovieId(5);
        int showtime = dao.getShowTime();
        System.out.println(MovieSession.getMovieId());
        System.out.println(showtime);
        view.highlightBookedButton(showtime);
    }
    public void open(){
        this.view.setVisible(true);
    }
    public void close(){
        this.view.dispose();
    }
}
