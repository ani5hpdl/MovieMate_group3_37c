/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Controller.MovieDetailsController;
import Doa.MovieDao;
import Model.MovieData;
import Model.MovieSession;
import java.awt.Image;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author anish
 */
public class DashboardCard extends javax.swing.JPanel {

    /**
     * Creates new form DashboardCard
     */
    public DashboardCard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MoviePoster = new javax.swing.JLabel();
        MovieName = new javax.swing.JLabel();
        Rating = new javax.swing.JLabel();
        Duration = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        ReleaseDate = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        MoviePoster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MoviePosterMouseClicked(evt);
            }
        });

        MovieName.setText("MovieName");

        Rating.setText("Rating");

        Duration.setText("Duration");

        ID.setBackground(new java.awt.Color(255, 255, 255));
        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setText("jLabel1");

        ReleaseDate.setText("jLabel1");
        ReleaseDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReleaseDateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(ReleaseDate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MoviePoster)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MovieName)
                                .addGap(18, 18, 18)
                                .addComponent(ID)
                                .addGap(0, 71, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Rating)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Duration)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MoviePoster)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MovieName)
                    .addComponent(ID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rating)
                    .addComponent(Duration))
                .addGap(3, 3, 3)
                .addComponent(ReleaseDate))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MoviePosterMouseClicked(java.awt.event.MouseEvent evt) {

        try {
            System.out.println("Before ");
            MovieDetails moviedetail = new MovieDetails();
            System.out.println("After");

            MovieDetailsController controller = new MovieDetailsController(moviedetail);
            int id = Integer.parseInt(ID.getText()); // Might throw NumberFormatException or NullPointerException
            MovieData movie = new MovieData(id, MovieName.getText(), "", "", 0, "", "", 0, "", null, "", "", "");
            System.out.println("✅ ID: " + id);
            
            controller.setMovieData(movie);
            MovieSession.setMovieId(id);
            controller.loadMovie();
            Window window = SwingUtilities.getWindowAncestor(this);
            if(window != null){
                window.dispose();
            }
            controller.open();
        } catch (Exception e) {
            System.err.println("❌ Exception occurred: " + e);
            e.printStackTrace(); // This will tell us EXACTLY where it's breaking
        }
    }


    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        System.out.println("Form");
    }//GEN-LAST:event_formMouseClicked

    private void ReleaseDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReleaseDateMouseClicked
        // TODO add your handling code here:
        System.out.println("Release Date");
    }//GEN-LAST:event_ReleaseDateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Duration;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel MovieName;
    private javax.swing.JLabel MoviePoster;
    private javax.swing.JLabel Rating;
    private javax.swing.JLabel ReleaseDate;
    // End of variables declaration//GEN-END:variables

    public void setMovie(MovieData moviedata){
        MovieName.setText(moviedata.getTitle());
        Duration.setText(String.valueOf(moviedata.getDuration()+ " min"));
        Rating.setText(String.valueOf("🌟"+moviedata.getRating()+"/10"));
        ID.setText(String.valueOf(moviedata.getId()));
        
        
        ImageIcon icon = new ImageIcon(moviedata.getPosterPath());
        Image img = icon.getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH);
        MoviePoster.setIcon(new ImageIcon(img));
    }
    public javax.swing.JLabel getIdField(){
        return ID;
    }
    public javax.swing.JLabel getMovieNameField(){
        return MovieName;
    }
    
    
}
