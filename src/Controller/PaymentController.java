/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.MovieDao;
import Doa.ProfileDao;
import Model.MovieData;
import Model.MovieSession;
import Model.PaymentModel;
import Model.ProfileModel;
import Model.UserSession;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import view.PaymentMethod;
import view.dashboard;

/**
 *
 * @author it solution
 */
public class PaymentController {
    
    private PaymentModel model;
    private final PaymentMethod userview;
    
    public PaymentController(PaymentModel model,PaymentMethod userview){
        this.model = model;
        this.userview = userview;
        
        this.userview.addCancelListener(new CancelListener());
        
        loadData();
    }
    
    private void loadData(){
        
        userview.getTicket().setText(String.valueOf(model.getTotalTickets()));
        userview.getSeatNo().setText(String.join(",",model.getSeatNumbers()));
        userview.getAmount().setText(String.valueOf(model.getAmountToBePaid()));
        userview.getMovieName().setText(model.getMovieName());
        userview.getLocations().setText(model.getLocation());
        userview.getHall().setText(model.getHall());
        userview.getTime().setText(model.getTime());
        userview.getUserName().setText(model.getCustomerName());
        userview.getEmail().setText(model.getEmail());
        userview.getPhoneNumber().setText(model.getPhoneNumber());
        
        ImageIcon icon1 = new ImageIcon(model.getPosterImagePath());
        Image img1 = icon1.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(img1);
        userview.getMoviePoster().setIcon(scaledIcon1);

    }
    
    public void open(){
        this.userview.setVisible(true);
    }
    
    public void close(){
        this.userview.dispose();
    }
    
    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dashboard dash = new dashboard();
            DashboardController controller = new DashboardController(dash);
            close();
            controller.open();
        }
        
    }
    
}
