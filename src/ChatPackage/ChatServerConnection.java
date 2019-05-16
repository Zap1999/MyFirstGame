package ChatPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatServerConnection {

    private Socket client;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ChatServerConnection() throws IOException {
        client = new Socket("localhost", 7777);
        out = new ObjectOutputStream(client.getOutputStream());
        in = new ObjectInputStream(client.getInputStream());
    }

    public ChatServerConnection(String host, int port) throws IOException {
        client = new Socket(host, port);
        out = new ObjectOutputStream(client.getOutputStream());
        in = new ObjectInputStream(client.getInputStream());
    }

    public ObjectOutputStream getOutStream() {
        return out;
    }

    public ObjectInputStream getInStream() {
        return in;
    }

    public void close() {
        try {
            in.close();
            out.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
