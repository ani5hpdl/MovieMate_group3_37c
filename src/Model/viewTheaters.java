/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 * A model class representing the user's selection for viewing theaters.
 */
public class viewTheaters {

    private String selectedCinema;
    private String selectedLanguage;
    private String selectedTime;
    private String selectedDate;
    private String searchQuery;

    public viewTheaters(String selectedCinema, String selectedLanguage, String selectedTime, String selectedDate, String searchQuery) {
        this.selectedCinema = selectedCinema;
        this.selectedLanguage = selectedLanguage;
        this.selectedTime = selectedTime;
        this.selectedDate = selectedDate;
        this.searchQuery = searchQuery;
    }
    public static void main(String[] args){
        System.out.println("This is the main method. You can run our code here.");
    }

    public String getSelectedCinema() {
        return selectedCinema;
    }

    public void setSelectedCinema(String selectedCinema) {
        this.selectedCinema = selectedCinema;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public String getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}

/**
 *
 * @author lenovo
 */

