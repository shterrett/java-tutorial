package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class FtpClient extends NetworkClient {
    public FtpClient(String host) {
        super(host, 21);
    }

    @Override
    protected void handleConnection(Socket client) throws IOException {
        final BufferedReader reader = SocketUtils.getReader(client);
        System.out.println(reader.readLine());
        client.close();
    }
}
