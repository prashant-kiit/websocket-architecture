package Client1;
import java.io.*;
import java.net.*;

public class Receiver1 implements Runnable {
    @Override
    public void run() {
        int port = 5001;
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader reader = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Client1 is listening on port " + port);
            socket = serverSocket.accept();
            System.out.println("Client2 connected");

            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));

            String message;
            while (true) {
                message = reader.readLine();
                if (message == null)
                    break; // Stop when the client disconnects
                System.out.println("Client2 says: " + message);
            }

            System.out.println("Client1 disconnected");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (socket != null)
                    socket.close();
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }    
}
