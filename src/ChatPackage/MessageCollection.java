package ChatPackage;

import EnemyPackage.Collection;
import EnemyPackage.Iterator;

public class MessageCollection implements Collection {

    public static final int MAX_ITEMS = 999;

    private int count = 0;

    private Message[] msgList;

    public MessageCollection() {
        msgList = new Message[MAX_ITEMS];

        // TODO: clear that (just testing)
        Message msg = new Message("Hello world!", "You");
        add(msg);
        add(new Message("Bye, bastard!", "qwe"));
        add(new Message("vdshdbfudjksfnsldkfnsdklfndslkfnsdlkfndskflsdf", "Someguy"));
    }

    public void add(Message m) throws RuntimeException {

        if(count >= MAX_ITEMS) {
            System.err.println("Message collection overflow.");
            throw new RuntimeException("Collection overflow");
        }
        else {
            msgList[count] = m;
            count++;
        }

    }

    @Override
    public Iterator createIterator() {
        return new MessageCollectionIterator(msgList);
    }


}
