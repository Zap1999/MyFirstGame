package chat;

import java.io.Serializable;
import java.util.ArrayList;

// Command operation (send)
public class SendOperation implements MessageOperation, Serializable {

    private Message message;
    public final OpType op = OpType.SEND;

    public SendOperation(Message message) {
        this.message = message;
    }

    @Override
    public ArrayList execute(ArrayList c) {
        c.add(message);
        return c;
    }

    @Override
    public OpType getType() {
        return op;
    }

    public Message getMessage() {
        return message;
    }

}
