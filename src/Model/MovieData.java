    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anish
 */
package Model;

import java.util.Date;

public class MovieData {
    private int id;
    private String title;
    private String director;
    private String cast;
    private int duration;
    private String genre;
    private String language;
    private int rating;
    private String synopsis;
    private Date releaseDate;
    private String showTime;
    private String posterPath;
    private String moreImagePath;

    // Constructor
    public MovieData(int id,String title, String director, String cast, int duration, String genre,
                     String language, int rating, String synopsis, Date releaseDate,
                     String showTime, String posterPath, String moreImagePath) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.duration = duration;
        this.genre = genre;
        this.language = language;
        this.rating = rating;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.showTime = showTime;
        this.posterPath = posterPath;
        this.moreImagePath = moreImagePath;
    }
    public MovieData(String title, String director, String cast, int duration, String genre,
                     String language, int rating, String synopsis, Date releaseDate,
                     String showTime, String posterPath, String moreImagePath) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.duration = duration;
        this.genre = genre;
        this.language = language;
        this.rating = rating;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.showTime = showTime;
        this.posterPath = posterPath;
        this.moreImagePath = moreImagePath;
    }

    // Getters and Setters
    public int getId(){ return id ;}
    public void setId(int id){ this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getCast() { return cast; }
    public void setCast(String cast) { this.cast = cast; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public int getRating() { return (int) rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public String getShowTime() { return showTime; }
    public void setShowTime(String showTime) { this.showTime = showTime; }

    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String posterPath) { this.posterPath = posterPath; }

    public String getMoreImagePath() { return moreImagePath; }
    public void setMoreImagePath(String moreImagePath) { this.moreImagePath = moreImagePath; }
}