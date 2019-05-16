package chat;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sender {

    private MessageOperation msg;

    public Sender(MessageOperation msg) {
        this.msg = msg;
    }

    public void send(ObjectOutputStream o) {

        try {
            o.writeObject(msg);
        }catch (IOException e) {
            System.err.println("Sending msg object failed.");
            e.printStackTrace();
        }

    }

}
