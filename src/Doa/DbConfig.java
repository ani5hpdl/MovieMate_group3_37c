// ─────────────────────────────────────────────────────────────────────────────
// File: DbConfig.java
// Package: DAO
// ─────────────────────────────────────────────────────────────────────────────

package Doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    // Make sure the URL uses the correct schema (database) name!
    private static final String URL =
        "jdbc:mysql://localhost:3306/movie?useSSL=false&serverTimezone=UTC";

    // Use exactly the user/pass that works in Workbench:
    private static final String USERNAME = "appuser";
    private static final String PASSWORD = "secret123!";

    static {
        try {
            // For MySQL Connector/J 8.x and 9.x
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // If you see this error, your MySQL connector JAR is missing from the project
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);}
}
