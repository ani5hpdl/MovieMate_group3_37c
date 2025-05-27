    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anish
 */
package Model;

public class MovieData {
    private String title;
    private String genre;
    private String language;
    private double rating;
    private String posterPath;
    private String moreImagePath;
    private String showTime;

    public MovieData(String title, String genre, String language, double rating,
                     String posterPath, String moreImagePath, String showTime) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.rating = rating;
        this.posterPath = posterPath;
        this.moreImagePath = moreImagePath;
        this.showTime = showTime;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String posterPath) { this.posterPath = posterPath; }

    public String getMoreImagePath() { return moreImagePath; }
    public void setMoreImagePath(String moreImagePath) { this.moreImagePath = moreImagePath; }

    public String getShowTime() { return showTime; }
    public void setShowTime(String showTime) { this.showTime = showTime; }
}

