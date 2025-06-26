package Doa;

import Model.Login;
import java.sql.Connection;
import Database.MySqlConnection;
import Model.UserRegisterModel;
import Model.UserSession;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDoa {
    MySqlConnection mysql= new MySqlConnection();
    
        public boolean validateuser(Login userlogin){
        Connection conn = mysql.openConnection();
        System.out.println("3");
        String sql = "SELECT * FROM user where email = ? and password = ?";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){

            pstm.setString(1,userlogin.getEmail());
            pstm.setString(2,userlogin.getPassword());
            ResultSet result = pstm.executeQuery();
            System.out.println(result.next());
            
            if(result.next()){
                int userid = result.getInt("id");
                UserSession.setUserId(userid);
            }
            return result.next();
            
        }catch(Exception ex){
            Logger.getLogger(UserRegisterDao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    } 
        
        
    public ResultSet checkuser(Login userlogin){
        Connection conn = mysql.openConnection();
        String sql = "SELECT role FROM user WHERE email = ? and password = ?";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){

            pstm.setString(1,userlogin.getEmail());
            pstm.setString(2,userlogin.getPassword());
//            ResultSet result = pstm.executeQuery();
            
//            return result;
            
        }catch(Exception ex){
            Logger.getLogger(UserRegisterDao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return null;
    }
}
