/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anish
 */
public class MovieSession {
    private static Integer movieId;
    
    public static void setMovieId(int id){
        movieId = id;
    }
    public static Integer getMovieId(){
        return movieId;  
    }
    public static void clear(){
        movieId = null;
    }
}
