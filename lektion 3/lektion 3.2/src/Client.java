import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final int PORT = 1234;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your name: ");
        String username = userInput.readLine();

        System.out.println("Enter your password: ");
        String password = userInput.readLine();

        out.println(username);
        out.println(password);
        String response = in.readLine();
        System.out.println(response);
        socket.close();
    }
}