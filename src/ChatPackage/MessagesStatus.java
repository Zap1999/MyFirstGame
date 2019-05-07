package ChatPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MessagesStatus {

    private MessageCollection messages = new MessageCollection();
    private ChatServerConnection connection;
    private ChatViewController controller;

    public MessagesStatus(ChatServerConnection conn, ChatViewController control) {
        connection = conn;
        controller = control;
    }

    private void getMessages() {
        try {
            ObjectOutputStream out = connection.getOutStream();
            out.writeObject(new UpdateOperation());
            ObjectInputStream in = connection.getInStream();
            try {
                MessageCollection msgs = (MessageCollection) in.readObject();
                MessageCollectionIterator it = (MessageCollectionIterator) msgs.createIterator();
                while(it.hasNext()) {
                    messages.add((Message) it.next());
                }
            }
            catch (ClassNotFoundException e) {
                System.err.println("Getting message collection from server failure.");
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            System.err.println("Creating stream for getting messages failure.");
            e.printStackTrace();
        }

    }

    public MessageCollection getMessageList() {
        getMessages();
        return this.messages;
    }

}
