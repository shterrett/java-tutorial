package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class RandomNumberServer {
    final private int port;
    public RandomNumberServer(int port) {
        this.port = port;
    }

    public void listen() {
        try (ServerSocket server = new ServerSocket(port)) {
            Socket socket;
            while (true) {
                socket = server.accept();
                handleConnection(socket);
                socket.close();
            }
        } catch (IOException e) {
               System.out.println(e);
        }
    }

    private void handleConnection(Socket socket) throws IOException {
       PrintWriter writer = SocketUtils.getWriter(socket);
       writer.println(new Random().nextInt());
    }
}
