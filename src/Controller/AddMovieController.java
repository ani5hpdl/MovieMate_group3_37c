    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import view.AdminPannel2;
import Doa.MovieDao;
import Model.MovieData;
import Model.TheaterandHall;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import view.AdminPanel;


/**
 *
 * @author anish
 */
public class AddMovieController {
    public final MovieDao movie = new MovieDao();
    private final AdminPannel2 addmovie;
    
    public AddMovieController(AdminPannel2 addmovie){
        this.addmovie = addmovie;
        addmovie.addAddMovieListener(new AddMovieListener());
        addmovie.addCancelMovieListener(new CancelMovieListener());
        
//        addmovie.addImageListener(new AddImageListener());
//        addmovie.addMoreImageListener(new MoreImageListener());
        
        addmovie.getMainImageButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFileChooser1();

            }
        });
        
        addmovie.getMoreImageButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFileChooser2();

            }
        });
    }
    public void open(){
        this.addmovie.setVisible(true);
    }
    public void close(){
        this.addmovie.dispose();
    }

    
    
    class AddMovieListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MovieDao movieDao = new MovieDao();
            try{
                String title = addmovie.getMovieNameField().getText();
                String director = addmovie.getDirectorField().getText();
                String cast = addmovie.getCastField().getText();
                int duration = (int) addmovie.getDurationSpinner().getValue();
                String genre = (String) addmovie.getGenreComboBox().getSelectedItem();
                String language = (String) addmovie.getLanguageComboBox().getSelectedItem();
                int rating = (int) addmovie.getRatingSpinner().getValue();
                String synopsis = addmovie.getSynopsisField().getText();
                Date releaseDate = addmovie.getReleaseDatePicker().getDate();
                String showTime = (String) addmovie.getShowTimeComboBox().getSelectedItem();
                String posterPath = addmovie.getMainImageButton().getText();
                String moreImagePath = addmovie.getMoreImageButton().getText();

                // Create movie object
                MovieData movieData = new MovieData(title, director, cast, duration, genre, language,
                                                    rating, synopsis, releaseDate, showTime, posterPath, moreImagePath);

                // Validate input
                String check = MovieDao.validate(movieData);
                if (check == null) {
                    movieDao.MovieDao(movieData);
                    JOptionPane.showMessageDialog(addmovie, "Movie inserted successfully.");
                    
                    AdminPanel adminpanel = new AdminPanel();
                    AdminPanelController controller =new AdminPanelController(adminpanel);
                    controller.open();
                    
                } else {
                    JOptionPane.showMessageDialog(addmovie, check);
                }

            }catch(Exception ex){
                System.out.println("Error Adding Movie"+ ex.getMessage());
            }
        }
        
    }
    class CancelMovieListener implements ActionListener{
 
        @Override
        public void actionPerformed(ActionEvent e) {
            addmovie.dispose();
            addmovie.setVisible(false);
        }
        
    }
    
    private void openFileChooser1() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Select the image");

        int result = jFileChooser.showOpenDialog(addmovie);
        if (result == JFileChooser.APPROVE_OPTION) {
            String productImage = jFileChooser.getSelectedFile().getAbsolutePath();
            addmovie.getMainImageButton().setText(productImage);

        }
    }
    private void openFileChooser2() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Select the image");

        int result = jFileChooser.showOpenDialog(addmovie);
        if (result == JFileChooser.APPROVE_OPTION) {
            String productImage = jFileChooser.getSelectedFile().getAbsolutePath();
            addmovie.getMoreImageButton().setText(productImage);

        }
    }

    
}
