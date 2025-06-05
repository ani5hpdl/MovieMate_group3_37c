// ─────────────────────────────────────────────────────────────────────────────
// File: DbConfig.java
// Package: DAO
// ─────────────────────────────────────────────────────────────────────────────

package Doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    // Update these constants to match your MySQL setup
    private static final String URL      = "jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "your_mysql_username";
    private static final String PASSWORD = "your_mysql_password";

    static {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // If the driver class isn’t found, halt initialization
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Opens and returns a new Connection to the MySQL database.
     * @return a live java.sql.Connection
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
