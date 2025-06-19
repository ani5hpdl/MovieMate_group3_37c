/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
// File: Movie.java


public class SearchMovie {
    private int id;
    private String title;
    private String genre;
    private String director;

    // Constructors
    

    public SearchMovie(String title, String genre, String director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
    } 

    // Getters and Setters

    public static void main(String[] args){
        System.out.println("This is the main method. You can run our code here.");
    }
     


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private static class Public {

        public Public() {
        }
    }
}


/**
 *
 * @author lenovo
 */
