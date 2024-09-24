import java.sql.*;
public class DatabaseConnection {
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:6306/it-sakerhet", "root", "");


            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return con;
    }
}
