/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.UserRegisterDao;
import Model.UserRegisterModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.UserLogin;
import view.UserRegister;

/**
 *
 * @author anish
 */
public class UserRegisterController {
    private final UserRegisterDao user = new UserRegisterDao();
    private final UserRegister userView;
    
    public UserRegisterController(UserRegister userView){
        this.userView = userView;
        userView.addAdduserListener(new AddUserListener());
    }
    
    public void open(){
        this.userView.setVisible(true);
    }
    
    public void close(){
        this.userView.dispose();
    }
    
    class AddUserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UserRegisterDao userDao = new UserRegisterDao();
            try{
                String FullName = userView.getnameField().getText();
                String Email = userView.getemailField().getText();
                String NewPassword = userView.getpasswordField().getText();
                String ConfirmPassword = userView.getpasswordField().getText();
                int ContactNumber = Integer.parseInt(userView.getnumberField().getText());
                String Address = userView.getaddressField().getText();
                
                UserRegisterModel user = new UserRegisterModel(FullName,Email,ContactNumber,Address,NewPassword,ConfirmPassword);
                boolean check = userDao.CheckUser(user);
                if(check){
                    JOptionPane.showMessageDialog(userView,"User Already Exists");
                }else if(!Email.contains("@")){
                    JOptionPane.showMessageDialog(userView,"Enter a Valid Email");
                }
                else if(!NewPassword.equals(ConfirmPassword)){
                    JOptionPane.showMessageDialog(userView,"Password doesnot Match");
                }
                else{
                    userDao.UserRegisterDao(user);
                    JOptionPane.showMessageDialog(null,"Registration Sucessful Redirecting to Login...");
                    
                    userView.dispose();
                    
                    UserLogin loginPage = new UserLogin();
                    loginPage.setVisible(true);
                    UserLogin UserLoginForm = new UserLogin();
                    LoginController controller = new LoginController(UserLoginForm);
                    controller.open();
                }
            }catch(Exception ex){
                System.out.println("Error Adding User"+ ex.getMessage());
            }
        }
    }
    
    
    
}
