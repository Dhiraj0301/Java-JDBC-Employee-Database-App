import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Dhiraj@1234";

    public static Connection getConnection() throws SQLException {
        try {
            // ✅ Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }

        // ✅ Now establish the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
