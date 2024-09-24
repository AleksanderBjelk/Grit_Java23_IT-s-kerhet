import java.sql.*;

public class DatabaseConnection {
    public static Connection connectDB() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:6306/it-sakerhet", "root", "");
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
            return null;
        }

    }

    public static void addUser(String name, String password, String email) {
        connectDB();
        String query = "INSERT INTO users (name, password, email) VALUES (?,?,?)";
        try {
            PreparedStatement insertStmt = connectDB().prepareStatement(query);

            insertStmt.setString(1, name);
            insertStmt.setString(2, password);
            insertStmt.setString(3, email);

            int addUser = insertStmt.executeUpdate();

            if (addUser > 0) {
                System.out.println("User added: ");
            } else {
                System.out.println("Error!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showUser() throws SQLException {
        connectDB();
        String query = "SELECT * FROM users";
        Statement statement = connectDB().createStatement();

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            System.out.println("-------------------");
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Password: " + rs.getString("password"));
            System.out.println("Email: " + rs.getString("email"));
        }
    }

    public static void deleteUser(String email) {
        String query = "DELETE FROM users where email = ?";
        try {
            PreparedStatement deleteStmt = connectDB().prepareStatement(query);

            deleteStmt.setString(1, email);

            int deleteUser = deleteStmt.executeUpdate();

            if (deleteUser > 0) {
                System.out.println("User deleted: ");
            } else {
                System.out.println("Error!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
