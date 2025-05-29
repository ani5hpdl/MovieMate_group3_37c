package Doa;

import Model.Login;
import java.sql.Connection;
import database.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDoa {
    MySqlConnection mysql= new MySqlConnection();
    
    public Login signin(Login loginRequest){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users where email = ? and password = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, loginRequest.getEmail());
            pstmt.setString(2, loginRequest.getPassword());
            try (ResultSet result = pstmt.executeQuery()) {
            if (result.next()) { 
                return new Login(
                   result.getString("email"),
                   result.getString("password")
               );   
            }
        }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return null;
    }
    
    public boolean checkUser(Login user){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users where email= ?";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, user.getEmail());
            try(ResultSet result = pstm.executeQuery()){
            return result.next();
            }
        }catch(SQLException ex){
            Logger.getLogger(LoginDoa.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
        }      
}
