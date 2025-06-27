
package Controller;


import Doa.LoginDoa;
import Model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.AdminPanel;
import view.ResetPassword;
import view.UserLogin;
import view.dashboard;




public class LoginController {
    private final LoginDoa logindao = new LoginDoa();
    private final UserLogin loginScreen;
    
    public LoginController(UserLogin loginScreen){
        this.loginScreen = loginScreen;
        loginScreen.addUserLoginListener(new UserLoginListener());
        loginScreen.addForgotPasswordListener(new ForgotPasswordListener());
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
                System.out.println(email);
                System.out.println(password);
//                boolean check = logindao.validateuser(userRequest);
                String user = logindao.checkUserRole(userRequest);
                System.out.println(user);
//                System.out.println(check);
                if(user.equals("admin")){
                    JOptionPane.showMessageDialog(loginScreen, "Login successful");
                    close();
                     AdminPanel adminpanel = new AdminPanel();
                     AdminPanelController controller =new AdminPanelController(adminpanel);
                     controller.open();
                }else if(user.equals("user")){
                    JOptionPane.showMessageDialog(loginScreen, "Login successful");
                    close();
                     dashboard dash = new dashboard();
                     DashboardController controller =new DashboardController(dash);
                     controller.open();
                }else{
                    JOptionPane.showMessageDialog(loginScreen, "Invalid Credentials");
                }
            }catch (Exception ex){
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
    class ForgotPasswordListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            close();
            ResetPassword resetpass = new ResetPassword();
            ResetPasswordController controller = new ResetPasswordController(resetpass);
            controller.open();
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
