import java.net.*;
import java.io.*;

public class TCPServer {

    public static void main (String[] args ) throws IOException {

        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(13267);

        while(true) {
            Socket clientSocket = null;
            clientSocket = serverSocket.accept();
            Thread t = new Thread(new ClientThread(clientSocket));
            t.start();
        }
    }
}
