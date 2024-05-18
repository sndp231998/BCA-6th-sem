import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Server's IP address
        int serverPort = 12345; // Server's port
        
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server at " + serverAddress + ":" + serverPort);
            
            // Set up input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            
            while (true) {
                System.out.print("Enter a message: ");
                userInput = consoleInput.readLine();
                
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                
                out.println(userInput); // Send message to server
                String response = in.readLine(); // Receive response from server
                System.out.println("Server: " + response);
            }
            
            // Close connections
            in.close();
            out.close();
            consoleInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
