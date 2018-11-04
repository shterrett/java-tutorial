package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class CurrentTime extends NetworkClient {
    public CurrentTime() {
        super("time-c.nist.gov", 13);
    }

    @Override
    protected void handleConnection(Socket client) throws IOException {
       final BufferedReader reader = SocketUtils.getReader(client);
       final PrintWriter writer = SocketUtils.getWriter(client);
       writer.println(timeRequest());
       reader.lines().forEach(System.out::println);
    }

    private String timeRequest() {
        return "GET / HTTP/1.1\n" +
                "Host: time-c.nist.gov\n" +
                "Connection: close\n" +
                "\n";
    }
}
