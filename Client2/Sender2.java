package Client2;
import java.io.*;
import java.net.*;

public class Sender2 implements Runnable {
    @Override
    public void run() {
        String hostname = "localhost";
        int port = 5001;
        Socket socket = null;
        BufferedWriter writer = null;
        BufferedReader consoleInput = null;

        try {
            socket = new Socket(hostname, port);
            OutputStream output = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(output));
            consoleInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to the client1. Type your message:");

            String message;
            while (true) {
                message = consoleInput.readLine();
                if (message == null || message.equalsIgnoreCase("exit"))
                    break;
                writer.write(message + "\n"); // Send message
                writer.flush();
            }

            System.out.println("Disconnected from client1.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
                if (consoleInput != null)
                    consoleInput.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
