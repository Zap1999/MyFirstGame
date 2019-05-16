package chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class DeleteOperation implements MessageOperation, Serializable {

    private Message message;
    public final OpType op = OpType.DELETE;

    public DeleteOperation(Message message) {
        this.message = message;
    }

    @Override
    public ArrayList execute(ArrayList c) {
        Iterator was = c.iterator();
        ArrayList willBe = new ArrayList();
        Message msg;
        while (was.hasNext()) {
            msg = (Message) was.next();
            if(!msg.equals(message)) {
                willBe.add(msg);
            }
        }
        return willBe;
    }

    @Override
    public OpType getType() {
        return op;
    }

    public Message getMessage() {
        return message;
    }

}
