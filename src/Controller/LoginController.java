
package Controller;


import Doa.LoginDoa;
import Model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.UserLogin;


public class LoginController {
    private final LoginDoa logindao = new LoginDoa();
    private final UserLogin loginScreen;
    
    public LoginController(UserLogin loginScreen){
        this.loginScreen = loginScreen;
        loginScreen.addUserLoginListener(new AddUserListener());
    }
    public void open(){
        this.loginScreen.setVisible(true);
    }
    public void close(){
        this.loginScreen.dispose();
    }
    
    class AddUserListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            try{
                String userName = loginScreen.gettextField().getText();
                String password = loginScreen.getpasswordField().getText();
                Login userRequest = new Login(userName, password);
                Login user  = new Login(userName, password);
                boolean check = logindao.checkUser(user);
                if(check){
                    JOptionPane.showMessageDialog(loginScreen, "Invalid Credentials");
                }else{
                    JOptionPane.showMessageDialog(loginScreen, "Login successful");
                }
            }catch (Exception ex){
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
}
