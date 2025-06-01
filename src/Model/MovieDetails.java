/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author it solution
 */

import java.util.List;




public class MovieDetails {

   
    private Long id;

    private String title;
    private int duration; // in minutes
    private String director;
    private double rating;

   
    private List<String> genres;

    
    private String synopsis;

  
    private List<String> cast;

    
    private List<String> photos;

    // Constructors
    public MovieDetails() {}

    public MovieDetails(String title, int duration, String director, double rating,
                 List<String> genres, String synopsis, List<String> cast, List<String> photos) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.rating = rating;
        this.genres = genres;
        this.synopsis = synopsis;
        this.cast = cast;
        this.photos = photos;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}