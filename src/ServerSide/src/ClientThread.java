import java.io.*;
import java.net.*;

public class ClientThread implements Runnable {
    private Socket connectionSocket;

    public ClientThread(Socket s) {
        this.connectionSocket = s;
    }

    public void run() {
        int bytesRead;

        try {
            InputStream in = connectionSocket.getInputStream();

            // Writing the file to disk
            // Instantiating a new output stream object
            OutputStream output = new FileOutputStream("teste.txt");

            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            // Closing the FileOutputStream handle
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
