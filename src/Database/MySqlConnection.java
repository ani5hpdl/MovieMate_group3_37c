package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
private final String URL = "jdbc:mysql://127.0.0.1:3306/moviemate?useSSL=false&allowPublicKeyRetrieval=true";
    private final String USER = "appuser";
    private final String PASSWORD = "app_password"; // change here

    public Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // optional for newer Java
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to database.");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver not found.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
