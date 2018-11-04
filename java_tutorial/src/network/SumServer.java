package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SumServer {
    final private int port;

    public SumServer(int port) {
        this.port = port;
    }

    public void listen() {
        int poolSize = 50 * Runtime.getRuntime().availableProcessors();
        ExecutorService tasks = Executors.newFixedThreadPool(poolSize);
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
               Socket socket = server.accept();
               tasks.execute(new SumHandler(socket));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
