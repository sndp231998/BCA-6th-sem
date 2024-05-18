import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Date;
import java.time.LocalDateTime;

public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 9999;
        DatagramSocket socket = new DatagramSocket(port);

        while (true) {
            // Receive a packet from the client
            byte[] RecData = new byte[1024];
            byte[] sendData=new byte[1024];

            DatagramPacket Recpacket = new DatagramPacket(RecData,RecData.length);
            socket.receive(Recpacket);

            // Get the client's address and port
            InetAddress address = Recpacket.getAddress();
            int clientPort = Recpacket.getPort();

            // Get the current date and time
            LocalDateTime Now = LocalDateTime.now();
        
            //convert date to string and byte
            sendData  = Now.toString().getBytes();

            // Create a new packet to send to the client
           DatagramPacket sndpkt = new DatagramPacket(sendData, sendData.length, address, clientPort);

            // Send the packet to the client
            socket.send(sndpkt);
        }
    }
}