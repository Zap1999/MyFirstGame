package ChatPackage;

import java.io.Serializable;

public class Message implements Serializable {

    private String text;
    private String sender;

    public Message(String t, String s) {
        text = t;
        sender = s;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

}
