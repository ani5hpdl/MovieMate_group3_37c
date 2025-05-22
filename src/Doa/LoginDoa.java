package Doa;

import Model.Login;
import java.sql.Connection;
import database.MySqlConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDoa {
    MySqlConnection mysql= new MySqlConnection();
    
    public void signin(Login user){
        Connection conn = mysql.openConnection();
        
        String sql = "INSERT INTO users(userName, password)VLAUES (?,?)";
        try(PreparedStatement pstm = conn.prepareStatement(sql) ){
            pstm.setString(1, user.getUserName());
            pstm.setString(2,user.getPassword());
            pstm.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(LoginDoa.class.getName()).log(Level.SEVERE, null,ex);
        }finally {
            mysql.closeConnection(conn);
        }
    }
}
