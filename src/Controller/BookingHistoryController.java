
package Controller;

import Doa.HistoryDao;
import Model.BookingHistory;
import Model.UserSession;
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
    
    
    public BookingHistoryController(bookinghistory bookingView){
        this.bookingView = bookingView;
//        UserSession.setUserId(5);

        
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
        List<BookingHistory> bookingHistory = bookingdao.getBookingHistory(UserSession.getUserId());
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

            List<BookingHistory> bookingHistory = bookingdao.getBookingHistoryByMovie(UserSession.getUserId(), movieTitle);

            if (bookingHistory.isEmpty()) {
               bookingView.showMessage("No bookings found for movie: " + movieTitle);
            } else {
               bookingView.populateBookingTable(bookingHistory);
            }
        }
    }
}
