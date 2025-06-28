
package Controller;

import Doa.HistoryDao;
import Model.BookingHistory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import view.bookinghistory;

/**
 *
 * @author ACER
 */
public class BookingHistoryController {
    private final HistoryDao bookingdao = new HistoryDao();
    private final bookinghistory bookingView;
    
    private int loggedInUser;
    
    public BookingHistoryController(bookinghistory bookingView, int userId){
        this.bookingView = bookingView;
        this.loggedInUser = userId;
        
        
        loadBookingHistory();
        bookingView.addSearchButtonListener(new SearchButtonListener());
        

    
    }
    
    public void open(){
        bookingView.setVisible(true);
    }
    
    public void close(){
        bookingView.dispose();
    }
    
    private void loadBookingHistory(){
        List<BookingHistory> bookingHistory = bookingdao.getBookingHistory(loggedInUser);
        bookingView.populateBookingTable(bookingHistory);
    }

    class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           String movieTitle = bookingView.getEnteredMovieTitle();

           if (movieTitle.isEmpty()) {
              bookingView.showMessage("Please enter a movie title.");
              return;
            }

            List<BookingHistory> bookingHistory = bookingdao.getBookingHistoryByMovie(loggedInUser, movieTitle);

            if (bookingHistory.isEmpty()) {
               bookingView.showMessage("No bookings found for movie: " + movieTitle);
            } else {
               bookingView.populateBookingTable(bookingHistory);
            }
        }
    }
}
