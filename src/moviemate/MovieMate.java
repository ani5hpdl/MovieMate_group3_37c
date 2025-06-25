/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviemate;
import Controller.BookingHistoryController;
import database.*;
import view.bookinghistory;
/**
 *
 * @author anish
 */
public class MovieMate {
    
    public static int loogedInUserId=1; //hardcoded for now, remove it later
    
    public static void main(String[] args) {
//        Database db = (Database) new MySqlConnection();
//        if(db.openConnection() != null){
//            System.out.println("Database connected Sucessfully");
//        }else{
//            System.out.println("Failed to connect to database");
//        }
    
//    int realUserId = loginController.getLoggedInUserId(); (for when passing realUserID, decomment it)

    bookinghistory bookingView = new bookinghistory();
    BookingHistoryController bookingController = new BookingHistoryController(bookingView, loogedInUserId);
    bookingController.open();
    }
}
