import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRegistration fileAccess =  new UserRegistration();

        System.out.println("Testar att läsa fil");
        fileAccess.readFileSafely("test.txt");

        System.out.println("\nTesting Unsecure file");
        fileAccess.readFileUnsafely("../insecureTest.txt");

        System.out.println("\nTesting secure access with directory traversal");
        fileAccess.readFileSafely("../insecureTest.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv ditt namn och lösenord: ");
        String name = scanner.nextLine();
        String password = scanner.nextLine();


    }
}