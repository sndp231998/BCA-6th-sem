import java.io.*;
import java.net.*;

public class DateAndTimeClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change this to the server's IP or hostname if needed
        int serverPort = 8085;

        try {
            Socket clientSocket = new Socket(serverAddress, serverPort);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String serverResponse;

            while ((serverResponse = in.readLine()) != null) {
                System.out.println("Server Response: " + serverResponse);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
