
package Controller;


import Doa.MovieDao;
import javax.swing.JButton;
import Doa.SeatDao;
import Model.Movie;
import Model.Seat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.CheckSeatAvailability;


public class SeatAvailabilityController {
    private final SeatDao seatDao;
    private final CheckSeatAvailability seatView;
    
    private final Map<String, Integer> movieMap = new HashMap<>();
    private final Map<String, Integer> showtimeMap = new HashMap<>();

    
    public SeatAvailabilityController(CheckSeatAvailability seatView) {
        this.seatView = seatView;
        this.seatDao = new SeatDao();
        
        seatView.initializeSeatButtons();
        
        addSeatButtonListeners();
        
        seatView.addMovieSelectionListener(new MovieSelectionListener());
        seatView.addSeatTypeFilterListener(new FilterSeatTypeListener());
        seatView.addShowTimeListener(new ShowTimeListener());
        
        loadMovie();
        loadSeatMap();
    }
    
    public void loadMovie(){
   
    }
    
    public void addSeatButtonListeners(){
        JButton[] buttons = seatView.getSeatButtons();
        for(int seatId = 1; seatId < buttons.length; seatId++){
            JButton btn = buttons[seatId];
            if(btn != null){
                
                btn.addActionListener(new SeatButtonSelectionListener());
                System.out.println("Listener attached to button " + seatId);

            }
        }
    }

    public void open() {
        seatView.setVisible(true);
    }

    public void close() {
        seatView.dispose();
    }
    
    private void loadSeatMap(){
        int movieId = seatView.getSelectedMovie();
        int showtimeId = seatView.getSelectedShowtime();
        
       
        List<Seat> seats = seatDao.fetchSeatsForMovieAndShowtime(movieId, showtimeId);
        updateSeatButtons(seats);
        
        int availableCount = seatDao.countAvailableSeats(movieId, showtimeId);
        seatView.updateAvailableSeat(availableCount);
        
        
        
    }
    //premium or regular
    private void applySeatFilterListener(){
        int movieId = seatView.getSelectedMovie();
        int showtimeId = seatView.getSelectedShowtime();
        String seatType = seatView.getSelectedSeatType();
        
        if (movieId == -1 || showtimeId == -1) return;
        
        List<Seat> filteredSeats = seatDao.fetchSeatsByType(movieId, showtimeId, seatType);
        updateSeatButtons(filteredSeats);

        int availableCount = 0;
        for (Seat seat : filteredSeats) {
            if (seat.isAvailable()) {
                availableCount++;
            }
        }
        seatView.updateAvailableSeat(availableCount);   
    }
    
    
private void updateSeatButtons(List<Seat>seats){
    JButton[] buttons = seatView.getSeatButtons();
            // Update buttons based on seat data
        for (Seat seat : seats) {
            try {
                int seatIndex = Integer.parseInt(seat.getSeatId().substring(1)); // Assumes seatId is like "A1"
                JButton button = buttons[seatIndex];
                if (button != null) {
                    button.setText(seat.getSeatId());

                    if (seat.isAvailable()) {
                        button.setEnabled(true);
                        if (seat.getSeatType().equalsIgnoreCase("Premium")) {
                            button.setBackground(java.awt.Color.CYAN);
                        } else {
                            button.setBackground(java.awt.Color.GREEN);
                        }
                        button.setForeground(java.awt.Color.BLACK);
                    } else {
                        button.setEnabled(false);
                        button.setBackground(java.awt.Color.RED);
                        button.setForeground(java.awt.Color.WHITE);
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid seat ID format: " + seat.getSeatId());
            }
        }
    }

    class MovieSelectionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            loadSeatMap();
        }
        
    }
    
    class FilterSeatTypeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            applySeatFilterListener();
        }
        
    }
    
    class ShowTimeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            loadSeatMap();
        }
        
    }
    
    class SeatButtonSelectionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selectedButton = (JButton) e.getSource();
            String seatNum = selectedButton.getText();
            String seatId = selectedButton.getText();
            
            
            System.out.println("Button Clicked: " + seatNum); // Log this first

//            int movieId = seatView.getSelectedMovie();
//            int showtimeId = seatView.getSelectedShowtime();
              
              int movieId = 1; // Use a valid movieId from your database
        int showtimeId = 1;
            System.out.println("Movie ID: " + movieId + " Showtime ID: " + showtimeId);

            
//            if (movieId == -1 || showtimeId == -1){
//                seatView.showMessage("Please select movie and showtime.");
//                return;
//                
//            }

            Seat seat = seatDao.findSeatBySeatNum(seatNum, movieId, showtimeId);

            if (seat != null) {
                if (seat.isAvailable()) {
                    boolean success = seatDao.updateSeatBookingStatus(seatId, movieId, showtimeId, true, "Booked");
                    if (success) {
                        // Directly update the button without reloading the whole seat map
                        selectedButton.setEnabled(false);
                        selectedButton.setBackground(java.awt.Color.RED);
                        selectedButton.setForeground(java.awt.Color.WHITE);
                        seatView.showMessage("Seat " + seatId + " successfully booked!");

                        int availableSeats = seatDao.countAvailableSeats(movieId, showtimeId);
                        seatView.updateAvailableSeat(availableSeats);
                    }
                } else {
                    seatView.showMessage("Seat " + seatId + " is already booked.");
                }
            }else{
                        seatView.showMessage("Seat not Found");
                        }
  
        }
        
    }
    
}
    