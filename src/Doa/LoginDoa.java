package Doa;

import Model.Login;
import java.sql.Connection;
import database.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class LoginDoa {
    MySqlConnection mysql= new MySqlConnection();
    
    public Login signin(Login loginRequest){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users where userName = ? and password = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, loginRequest.getEmail());
            pstmt.setString(2, loginRequest.getPassword());
            ResultSet result = pstmt.executeQuery();
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return null;
    }
    
    
        
    

    
}
