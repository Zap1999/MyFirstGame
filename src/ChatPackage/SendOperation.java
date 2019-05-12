package ChatPackage;

import java.io.Serializable;

import static ChatPackage.OpType.SEND;

// Command operation (send)
public class SendOperation implements MessageOperation, Serializable {

    private Message message;
    public final OpType op = SEND;

    public SendOperation(Message message) {
        this.message = message;
    }

    @Override
    public MessageCollection execute(MessageCollection c) {
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
