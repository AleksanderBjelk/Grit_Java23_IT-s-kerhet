import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("1. Skapa konto");
            System.out.println("2. Visa konto");
            System.out.println("3. Radera konto");
            System.out.println("4. Avsluta");

            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Name:");
                String name = scanner.next();

                System.out.println("Password: ");
                String password = scanner.next();

                System.out.println("Email: ");
                String email = scanner.next();

                DatabaseConnection.addUser(name, password, email);
            }

            if (choice == 2) {
                DatabaseConnection.showUser();
            }


            if (choice == 3) {
                System.out.println("Write your email to delete your account: ");
                String email = scanner.next();
                DatabaseConnection.deleteUser(email);
            }

            if (choice == 4) {
                System.out.println("Goodbye");
            }

            Connection con = DatabaseConnection.connectDB();

        }


    }
}