package Doa;

import Model.Login;
import java.sql.Connection;
import Database.MySqlConnection;
import Model.UserRegisterModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDoa {
    MySqlConnection mysql= new MySqlConnection();
    
        public boolean validateuser(Login userlogin){
        Connection conn = mysql.openConnection();
        System.out.println("3");
        String sql = "SELECT * FROM user where email = ? and password = ?";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            System.out.println("Login email"+ userlogin.getEmail());
            System.out.println("Login Password"+ userlogin.getPassword());

            pstm.setString(1,userlogin.getEmail());
            pstm.setString(2,userlogin.getPassword());
            ResultSet result = pstm.executeQuery();
            return result.next();
        }catch(Exception ex){
            Logger.getLogger(UserRegisterDao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }  
}
