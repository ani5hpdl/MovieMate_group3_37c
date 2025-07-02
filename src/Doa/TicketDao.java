/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doa;
import Model.TicketModel;
import database.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lenovo
 */
public class TicketDao {
    
    MySqlConnection mysql = new MySqlConnection();
    
    public boolean saveTicket(Ticket ticket){
        Connection conn = mysql.openconnection();
        
        try{
            String query = "Insert Into ticket (movieName, duration, date, time, seatNo, theaterNo, vat, totalAmount)"+
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?,)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, ticket.getMovieName());
            stmt.setString(2, ticket.getDuration());
            stmt.setString(3, ticket.getDate());
            stmt.setString(4, ticket.getTime());
            stmt.setString(5, ticket.getSeatNo()); 
            stmt.setString(6, ticket.getTheaterNo());
            stmt.setString(7, ticket.getVat());
            stmt.setString(8, ticket.getTotalAmount());
            
            int rows = stmt. ExecuteUpdate();
            
            return rows > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        }
    }
    public static void main(String[] args){
        TicketDao dao =new TicketDao();
    }
    
}
