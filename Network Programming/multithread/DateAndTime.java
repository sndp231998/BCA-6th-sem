import java.io.*;
import java.net.*;
import java.util.Date;

public class DateAndTime {
    static int port = 8085;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new DateAndTimeThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class DateAndTimeThread extends Thread {
        Socket connection;

        DateAndTimeThread(Socket connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.write("From server" + "\r\n");
                out.flush();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
