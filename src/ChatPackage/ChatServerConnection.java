package ChatPackage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatServerConnection {

    private Socket client;
    private ObjectOutputStream out;

    public ChatServerConnection() throws IOException {
        client = new Socket("localhost", 7777);
        out = new ObjectOutputStream(client.getOutputStream());
    }

    public ChatServerConnection(String host, int port) throws IOException {
        client = new Socket(host, port);
        out = new ObjectOutputStream(client.getOutputStream());
    }

    public ObjectOutputStream getOutStream() {
        return out;
    }

}
