/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 * A model class representing the user's selection for viewing theaters.
 */
public class TheaterandHall {

    private String Location;
    private String Theater;
    private String Hall;
    private String Time;

    public TheaterandHall(String Location, String Theater, String Hall, String Time){
        this.Location = Location;
        this.Theater = Theater;
        this.Hall = Hall;
        this.Time = Time;
    }
    
    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTheater() {
        return Theater;
    }

    public void setTheater(String theater) {
        Theater = theater;
    }

    public String getHall() {
        return Hall;
    }

    public void setHall(String hall) {
        Hall = hall;
    }

    
    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    
}

/**
 *
 * @author lenovo
 */

