import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Port to listen on
        
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
            
            Socket clientSocket = serverSocket.accept(); // Wait for a client to connect
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            
            // Set up input and output streams for client communication
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Set up input and output streams for server communication
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(System.in));
           // PrintWriter serverOut = new PrintWriter(System.out, true);
            
            // Start separate thread for reading client messages
            Thread clientReaderThread = new Thread(() -> {
                String clientMessage;
                try {
                    while ((clientMessage = clientIn.readLine()) != null) {
                        System.out.println("Client: " + clientMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            clientReaderThread.start();
            
            String serverMessage;
            while (true) {
                serverMessage = serverIn.readLine(); // Read server's message
                if (serverMessage != null) {
                    clientOut.println("Server: " + serverMessage); // Send message to client
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
