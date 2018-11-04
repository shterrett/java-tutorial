package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class UrlExists extends NetworkClient {
    final private String path;

    public UrlExists(String url, String path) {
        super(url, 80);
        this.path = path;
    }

    @Override
    protected void handleConnection(Socket client) throws IOException {
        final BufferedReader reader = SocketUtils.getReader(client);
        final PrintWriter writer = SocketUtils.getWriter(client);
        writer.println(headRequest());
        if (reportSuccess(reader.readLine())) {
            System.out.println("IT EXISTS");
        } else {
            System.out.println("NOT HERE");
        }
        client.close();
    }

   private String headRequest() {
        return  String.format("HEAD /%s HTTP/1.1\n", path) +
                String.format("Host: %s%n", getHost()) +
                "Connection: close\n" +
                "\n";
   }

   private boolean reportSuccess(String resp) {
       Integer statusCode = Integer.parseInt(resp.split(" ")[1]);
       return 200 <= statusCode && statusCode < 400;
   }
}
