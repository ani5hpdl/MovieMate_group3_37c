/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.MovieDao;
import Model.MovieData;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import view.MovieDetails;

/**
 *
 * @author anish
 */
public class MovieDetailsController {
    public final MovieDetails moviedet;
    public MovieDao movie;
    private MovieData moviedata;
    private int movieId;
    
    public MovieDetailsController(MovieDetails moviedet){
        this.moviedet = moviedet; 
        this.movie = new MovieDao();
    }
    public void open(){
        this.moviedet.setVisible(true);
    }
    public void close(){
        this.moviedet.dispose();
    }
    
    public void setMovieData(MovieData moviedata){
        this.movieId = moviedata.getId();
        this.moviedata = moviedata;  
    }
    public MovieData fetchMovie(MovieData moviedata){
        if (moviedata == null) {
            System.err.println("fetchMovie() error: moviedata is null.");
            return null;
        }
        movieId = moviedata.getId();
//        System.out.println(movie.getMovieById(movieId));
        return movie.getMovieById(movieId);
    }
    
    public void loadMovie(){
        this.setMovieData(moviedata);
        MovieData data = this.fetchMovie(moviedata);
        
        if(data != null){
            moviedet.getMovieNameField().setText(data.getTitle());
            moviedet.getDirectorField().setText("Director: "+data.getDirector());
            moviedet.getCastField().setText(data.getCast());
            moviedet.getDurationField().setText("Duration: "+String.valueOf(data.getDuration())+" min");
            moviedet.getGenreField().setText(String.valueOf("Genre: "+data.getGenre()));
            moviedet.getRatingField().setText(String.valueOf("Rating: "+data.getRating()+"/10"));
            moviedet.getSynopsisField().setText(data.getSynopsis());
            
            ImageIcon icon1 = new ImageIcon(data.getPosterPath());
            Image img1 = icon1.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon1 = new ImageIcon(img1);
            moviedet.getPosterImageField().setIcon(scaledIcon1);

            // Force correct size in layout
            moviedet.getPosterImageField().setPreferredSize(new Dimension(180, 180));
            moviedet.getPosterImageField().revalidate();
            moviedet.getPosterImageField().repaint();

            
            ImageIcon icon2 = new ImageIcon(data.getMoreImagePath());
            Image img2 = icon2.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon2 = new ImageIcon(img2);
            moviedet.getMoreImageField().setIcon(scaledIcon2);

            moviedet.getMoreImageField().setPreferredSize(new Dimension(180, 180));
            moviedet.getMoreImageField().revalidate();
            moviedet.getMoreImageField().repaint();

        }
    }
    
}
