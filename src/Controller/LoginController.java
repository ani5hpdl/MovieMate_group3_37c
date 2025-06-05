
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
        loginScreen.addUserLoginListener(new UserLoginListener());
    }
    public void open(){
        this.loginScreen.setVisible(true);
    }
    public void close(){
        this.loginScreen.dispose();
    }
    
    class UserLoginListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                System.out.println("gfhjk");
                String email = loginScreen.getemailField().getText();
                String password = loginScreen.getpasswordField().getText();
                Login userRequest = new Login(email, password);
                boolean check = logindao.validateuser(userRequest);
                if(check){
                    JOptionPane.showMessageDialog(loginScreen, "Login successful");
                }else{
                    JOptionPane.showMessageDialog(loginScreen, "Invalid Credentials");
                }
            }catch (Exception ex){
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
}
