
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
        
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                
                String email = loginScreen.gettextField().getText();
                String password = loginScreen.getpasswordField().getText();
                System.out.print(email);
                System.out.print(password);
                Login user = new Login(email,password);
                String error = ValidateLogin(user);
                  if (error != null) {
            JOptionPane.showMessageDialog(loginScreen, error);
            return;
        }
             Login result = logindao.signin(user);
                if(result == null){
                    JOptionPane.showMessageDialog(loginScreen, "Login successfull");
                }else{
                   JOptionPane.showMessageDialog(loginScreen, "Invalid Credentials"); 
                }
            }catch (Exception ex){
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
    public static String ValidateLogin(Login loginRequest){
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        if (email == null || email.trim().isEmpty()){
            return "Email is required";
        }
        if (password == null || password.trim().isEmpty()) {
            return "Password is required.";
        }
        return null;
    }
    
}
