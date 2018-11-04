package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SumHandler implements Runnable {
    private final BufferedReader reader;
    private final PrintWriter writer;
    private final Socket socket;

    public SumHandler(Socket socket) throws IOException {
        this.reader = SocketUtils.getReader(socket);
        this.writer = SocketUtils.getWriter(socket);
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Integer x = Integer.parseInt(reader.readLine());
            Integer y = Integer.parseInt(reader.readLine());
            writer.println(x + y);
            socket.close();
        } catch (IOException e) {
            writer.println(e);
        }
    }
}
