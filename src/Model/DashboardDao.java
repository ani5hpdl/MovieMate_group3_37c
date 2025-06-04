/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author NITRO
 */
public class DashboardDao {
    
    private String title;
    private String genre;
    private String language;
    private String date;
    private String coverImage;
    private String moreImage;

    // Constructor
    public DashboardDao(String title, String genre, String language, String date, String coverImage, String moreImage) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.date = date;
        this.coverImage = coverImage;
        this.moreImage = moreImage;
    }

    private DashboardDao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter and Setter for language
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // Getter and Setter for date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Getter and Setter for coverImage
    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    // Getter and Setter for moreImage
    public String getMoreImage() {
        return moreImage;
    }

    public void setMoreImage(String moreImage) {
        this.moreImage = moreImage;
    }
    
public static void main(String[] args) {
    DashboardDao dashboardDao = new DashboardDao();
}


}
