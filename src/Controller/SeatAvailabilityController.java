/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Doa.SeatDao;
import Model.Seat;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CheckSeatAvailability;


public class SeatAvailabilityController {
      private final SeatDao seatDao;
    private final CheckSeatAvailability seatView;

    public SeatAvailabilityController(CheckSeatAvailability seatView) {
        this.seatView = seatView;
        this.seatDao = new SeatDao();

        seatView.addMovieSelectionListener(new LoadSeatMapListener());
        seatView.addSeatTypeFliterListener(new FilterSeatTypeListener());
    }

    public void open() {
        seatView.setVisible(true);
    }

    public void close() {
        seatView.dispose();
    }
}
    