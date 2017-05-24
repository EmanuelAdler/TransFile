import java.io.*;
import java.net.*;

public class ClientThread implements Runnable {
    private Socket connectionSocket;

    public ClientThread(Socket s) {
        this.connectionSocket = s;
    }

    public void run() {
        int bytesReaded;

        try {
            InputStream in = connectionSocket.getInputStream();

            // WRITE FILE
            OutputStream output = new FileOutputStream("teste.txt");

            byte[] buffer = new byte[1024];
            while ((bytesReaded = in.read(buffer)) != -1) {
                output.write(buffer, 0, bytesReaded);
            }
            // CLOSE STREAM HANDLE
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
