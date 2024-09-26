import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private static final int PORT =1234;

    private static final HashMap<String, String> credentials = new HashMap<>();
    public static void main(String[]args) throws IOException {

        credentials.put("anv1" , "lösenord1");
        credentials.put("anv2", "lösenord2");

        ServerSocket serverSocket = new ServerSocket(PORT);

        try{
            while(true){
                Socket socket = serverSocket.accept();
                try {
                    handleClient(socket);
                } catch (IOException e){
                    System.out.println(e);
                    socket.close();
                }
            }
        } finally {
            serverSocket.close();
        }

    }
    private static void handleClient(Socket socket) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        String user = in.readLine();
        String password = in.readLine();

        if(credentials.containsKey(user) && credentials.get(user).equals(password)){
            out.println("Success " + "Welcome " + user + "!");
        } else {
            out.println("Failure");
        }
        socket.close();
    }
}
