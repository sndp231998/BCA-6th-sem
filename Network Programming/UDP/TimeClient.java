import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TimeClient {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 9999;
       InetAddress ip= InetAddress.getByName(host);

        // Create a socket to connect to the server
        DatagramSocket cs = new DatagramSocket();

        // Create a byte 
        byte[] senddata = new byte[1024];
         byte[] Recdata = new byte[1024];

        senddata="date".getBytes();
        DatagramPacket sendpkt = new DatagramPacket(senddata, senddata.length, ip, port);
        // Send the packet to the server
       cs.send(sendpkt);


        // Receive a packet from the server
    
       DatagramPacket  recpkt = new DatagramPacket(Recdata, Recdata.length);
        cs.receive(recpkt);

        // Get the date and time from the server
        String time = new String(recpkt.getData(), 0, recpkt.getLength());

        // Print the date and time
        System.out.println("The time is: " + time);
    }
}