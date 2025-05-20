/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author it solution
 */
import javax.swing.*;
import java.awt.*;

public class dashboard extends JFrame {

    public dashboard() {
        setTitle("Moviemate Dashboard");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Sidebar
        add(createSidebar(), BorderLayout.WEST);

        // Main content
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.add(createSearchBar(), BorderLayout.NORTH);
        mainContent.add(createMovieList(), BorderLayout.CENTER);
        add(mainContent, BorderLayout.CENTER);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(45, 45, 60));
        sidebar.setPreferredSize(new Dimension(200, 600));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("Moviemate", JLabel.CENTER);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(logo);
        sidebar.add(Box.createVerticalStrut(20));

        String[] menuItems = {"Home", "Profile", "Transaction", "History", "Log Out"};
        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            styleSidebarButton(button);
            sidebar.add(button);
            sidebar.add(Box.createVerticalStrut(10));
        }

        return sidebar;
    }

    private void styleSidebarButton(JButton button) {
        button.setFocusPainted(false);
        button.setBackground(new Color(60, 60, 80));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    private JPanel createSearchBar() {
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField("Search movies...", 40);
        searchField.setPreferredSize(new Dimension(400, 30));
        searchPanel.add(searchField);
        return searchPanel;
    }

    private JScrollPane createMovieList() {
        JPanel movieContent = new JPanel();
        movieContent.setLayout(new BoxLayout(movieContent, BoxLayout.Y_AXIS));
        movieContent.add(createMovieSection("Now Showing", new String[]{
            "Killers Of The Flower Moon", "Mission Impossible", "Avatar", "Oppenheimer", "Deadpool 3"
        }));
        movieContent.add(createMovieSection("Coming Soon", new String[]{
            "House Of The Dragon", "The Last Of Us", "Planet Earth"
        }));
        return new JScrollPane(movieContent);
    }

    private JPanel createMovieSection(String title, String[] movies) {
        JPanel section = new JPanel(new BorderLayout());
        section.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        section.add(titleLabel, BorderLayout.NORTH);

        JPanel moviePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (String movie : movies) {
            moviePanel.add(createMovieCard(movie));
        }

        section.add(moviePanel, BorderLayout.CENTER);
        return section;
    }

    private JPanel createMovieCard(String title) {
        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(120, 180));
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel movieLabel = new JLabel("<html><center>" + title + "</center></html>", JLabel.CENTER);
        movieLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        card.add(movieLabel, BorderLayout.CENTER);

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new dashboard().setVisible(true));
    }
}