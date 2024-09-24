import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection con = DatabaseConnection.connectDB();


        if (con != null) {
            System.out.println("Anslutning till databasen lyckades!");
        } else {
            System.out.println("Misslyckades att ansluta till databasen.");
        }
    }

}