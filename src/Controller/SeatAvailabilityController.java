   
package Controller;

import Doa.MovieDao;
import Doa.ProfileDao;
import Doa.SeatDao;
import Model.MovieData;
import Model.MovieSession;
import Model.PaymentModel;
import Model.ProfileModel;
import Model.Seat;
import Model.TheaterandHall;
import Model.UserSession;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import view.CheckSeatAvailability;
import view.PaymentMethod;

public class SeatAvailabilityController {
    private final SeatDao seatDao;
    private final CheckSeatAvailability seatView;
    private TheaterandHall hall;
    public MovieDao movie;
    private MovieData moviedata;
    private ProfileModel profile;


    private Map<String, JButton> seatButtonMap = new HashMap<>();
    private String selectedmovie;
    private String selectedShowtime ;
    private String selectedSeats;
    
    private List<String> selectedSeatNumbers = new ArrayList<>();
    private final int SEAT_SELECTION_LIMIT = 5;


    public SeatAvailabilityController(CheckSeatAvailability seatView, TheaterandHall hall) {
        this.seatView = seatView;
        this.seatDao = new SeatDao();
        this.hall = hall;
        this.movie = new MovieDao();


        mapSeatButtons();
        addSeatButtonListeners();

        seatView.addSeatTypeFilterListener(new FilterSeatTypeListener());
        seatView.addConfirmButtonListener (new ConfirmButtonListener());
        loadData();
        moviedata = movie.getMovieById(MovieSession.getMovieId());
        this.selectedmovie = moviedata.getTitle();
        this.selectedShowtime = hall.getTime();
    }
    
    private void loadData(){
        
        seatView.getShowTime().setText(hall.getTime());
        seatView.getLocationPoint().setText(hall.getTheater());
        seatView.getHallName().setText(hall.getHall());
        moviedata = movie.getMovieById(MovieSession.getMovieId());
        seatView.getMovieNameLabel().setText(moviedata.getTitle());
        
        List<Seat> filteredSeats;
        filteredSeats = seatDao.fetchSeatsByStatus(selectedmovie, selectedShowtime, "Booked");
        updateSeatButtons(filteredSeats);


    }
    
    private void mapSeatButtons() {
    JButton[] buttons = seatView.getSeatButtons(); 

    String[] seatLabels = {
        "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9",
        "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9",
        "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9",
        "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9",
        "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9",
        "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9",
        "G0", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9",
        "H0", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9"
    };

    for (int i = 0; i < buttons.length && i < seatLabels.length; i++) {
        if (buttons[i] != null) {
            seatButtonMap.put(seatLabels[i], buttons[i]);
            buttons[i].setText(seatLabels[i]); // Make sure the button displays the correct seat number
        }
    }
}

    public void addSeatButtonListeners() {
        for (Map.Entry<String, JButton> entry : seatButtonMap.entrySet()) {
            JButton button = entry.getValue();
            if (button != null) {
                button.addActionListener(new SeatButtonSelectionListener());
                System.out.println("Listener attached to button " + entry.getKey());
            }
        }
    }

    public void open() {
        seatView.setVisible(true);
    }

    public void close() {
        seatView.dispose();
    }

    private void loadSeatMap() {
        if (selectedmovie.isEmpty() || selectedShowtime.isEmpty()){
            return;
        }
        
        List<Seat> seats = seatDao.fetchSeatsForMovieAndShowtime(selectedmovie, selectedShowtime);
        updateSeatButtons(seats);

        int availableCount = seatDao.countAllAvailableSeats(selectedmovie, selectedShowtime);
        seatView.updateAvailableSeat(availableCount);
    }

    private void applySeatFilterListener() {
        if(selectedmovie.isEmpty() || selectedmovie == null){
            System.out.println("Please select a movie first.");
            return;
        }
        if(selectedShowtime == null || selectedShowtime.isEmpty()){
            System.out.println("Please select a showtime first");
            return;
        }
        
        String seatType = seatView.getSelectedSeatType();
        List<Seat> filteredSeats;

        switch (seatType) {
            case "All":
                filteredSeats = seatDao.fetchSeatsForMovieAndShowtime(selectedmovie, selectedShowtime);
                break;
            case "Booked":
                filteredSeats = seatDao.fetchSeatsByStatus(selectedmovie, selectedShowtime, "Booked");
                break;
            default:
                filteredSeats = seatDao.fetchSeatsByType(selectedmovie, selectedShowtime, seatType);
                break;
        }
        
        updateSeatButtons(filteredSeats);

        int availableCount = 0;
        for (Seat seat : filteredSeats) {
            if (seat.isAvailable()) {
                availableCount++;
            }
        }
        seatView.updateAvailableSeat(availableCount);
    }   
    
    

    private void updateSeatButtons(List<Seat> seats) {
        // Reset all buttons
        for (JButton button : seatButtonMap.values()) {
            button.setEnabled(true);
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
        }

        for (Seat seat : seats) {
            JButton button = seatButtonMap.get(seat.getSeatNum());

            if (button != null) {
                button.setText(seat.getSeatNum());

                if (seat.isAvailable()) {
                    button.setEnabled(true);
                    if (seat.getSeatType().equalsIgnoreCase("Premium")) {
                        button.setBackground(Color.getHSBColor(0.13f, 1.00f, 1.00f));
                    } else {
                        button.setBackground(Color.getHSBColor(0.57f, 0.60f, 1.00f));
                    }
                    button.setForeground(Color.BLACK);
                } else {
                    button.setEnabled(false);
                    button.setBackground(Color.getHSBColor(0.97f, 0.91f, 0.86f));
                    button.setForeground(Color.WHITE);
                }
            } else {
                System.out.println("Button not found for seat: " + seat.getSeatNum());
            }
        }
    }
    
    
    class FilterSeatTypeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Filter Changed to: " + seatView.getSelectedSeatType());
            applySeatFilterListener();
        }
    }

    class SeatButtonSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            if (selectedmovie == null || selectedmovie.isEmpty() || selectedShowtime == null || selectedShowtime.isEmpty()) {
//             seatView.showMessage("Please select a movie and showtime first.");
//             return;
//            }      

            
            JButton selectedButton = (JButton) e.getSource();
            String seatNum = selectedButton.getText();

            System.out.println("Button Clicked: " + seatNum);

            Seat seat = seatDao.findSeatBySeatNum(selectedmovie, selectedShowtime, seatNum);

//            if (seat != null) {
//                if (seat.isAvailable()) {
//                    String seatDetails = "Seat Number: " + seat.getSeatNum() +
//                                         "\nSeat Type: " + seat.getSeatType() + 
//                                         "\nSeat Status: " + seat.getStatus();
//                    
//                    seatView.showMessage(seatDetails);
//                } 
//            } else {
//                seatView.showMessage("Seat not Found");
//            }
//        }
//    }
//}    
           if (selectedSeatNumbers.contains(seatNum)){
               selectedSeatNumbers.remove(seatNum);
               selectedButton.setBackground(Color.LIGHT_GRAY);
           } else {
               if (selectedSeatNumbers.size()>= SEAT_SELECTION_LIMIT) {
                   seatView.showMessage("You can select up to " + SEAT_SELECTION_LIMIT + "seats.");
                   return;
                   
               }
               selectedSeatNumbers.add(seatNum);
               selectedButton.setBackground(Color.GREEN);
           } 
           System.out.println("Selected seats: "+ selectedSeatNumbers);
        }
    }



class ConfirmButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (selectedSeatNumbers.isEmpty()) {
            seatView.showMessage("No seats selected to confirm.");
            return;
        }

        // List to store seat model objects
        List<Seat> confirmedSeats = new ArrayList<>();
        
         // Get seat type based on hall name
        String hallName = hall.getHall();
        String seatType;

        switch (hallName) {
            case "HallA":
                seatType = "Premium";
                break;
            case "HallB":
                seatType = "Standard";
                break;
            case "HallC":
                seatType = "IMAX";
                break;
            default:
                seatType = "Standard"; // fallback
        }

        for (String seatNum : selectedSeatNumbers) {
            // Get seat info from DAO (or manually create if no DB call)
            Seat seat = seatDao.findSeatBySeatNum(selectedmovie, selectedShowtime, seatNum);
            
            if (seat == null) {
                // If no DB, create manually
                seat = new Seat(
                    UUID.randomUUID().toString(), // seatId (use random or leave blank)
                    seatNum,
                    seatType,                    // or "Premium", adjust logic
                    "Booked",
                    selectedmovie,
                    selectedShowtime
                );
            } else {
                seat.setStatus("Booked"); // just update model status
            }

            confirmedSeats.add(seat);

            // UI: disable button
            JButton btn = seatButtonMap.get(seatNum);
            if (btn != null) {
                btn.setEnabled(false);
                btn.setBackground(Color.RED);
            }
        }

        // Optional: store confirmedSeats to controller's field
        System.out.println("Confirmed seat data:");
        for (Seat s : confirmedSeats) {
            System.out.println(s);
        }
        
        seatView.showMessage("Seats selected successfully: " + selectedSeatNumbers);
        
        MovieDao movie = new MovieDao();
        moviedata = movie.getMovieById(MovieSession.getMovieId());
        
        ProfileDao ppdao = new ProfileDao();
        profile = ppdao.getUserById(UserSession.getUserId());
                
        PaymentMethod pay = new PaymentMethod();
        PaymentModel model = new PaymentModel(1,selectedSeatNumbers,350,moviedata.getTitle(),hall.getLocation(),hall.getHall(),
                                                hall.getTime(),moviedata.getPosterPath(),profile.getFullname(),profile.getEmail(),
                                                profile.getContactNumber());
        PaymentController controller = new PaymentController(model,pay);
        controller.open();

        // Clear UI selection
        selectedSeatNumbers.clear();
        

        
        
    }
}

}


    
