package ChatPackage;

import EnemyPackage.Iterator;
import GamePackage.ContextOriginator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ListIterator;

public class ChatViewController {
    private static int PORT = 7776;
    private ChatServerConnection connection;
    private MessagesStatus messagesController;

    private Stage stage;
    @FXML
    BorderPane mainPane;
    @FXML
    VBox msgsBox;
    @FXML
    TextArea myMsg;

    @FXML
    public void initialize() {

        makeConnection("localhost", PORT);
        PORT++;
        messagesController = new MessagesStatus(connection, this);
        refresh();
    }

    @FXML
    private void back() throws IOException {
        connection.close();
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("../MenuPackage/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void addMsg(Message msg) {
        HBox hBox = new HBox();
        VBox box = new VBox();

        Text msgText = new Text(msg.getText() + "\n");
        msgText.setWrappingWidth(150);
        msgText.intersects(5,5,5,5);
        box.getChildren().add(msgText);

        Text sender = new Text(msg.getSender());
        sender.setWrappingWidth(100);
        sender.intersects(5,5,5,5);
        box.getChildren().add(sender);

        box.setStyle("-fx-background-color: #B0BEC5;");
        box.setMaxWidth(200);

        hBox.getChildren().add(box);
        hBox.setAlignment((msg.getSender().equalsIgnoreCase(ContextOriginator.getCurrentState().getName()))
                ?Pos.CENTER_RIGHT:Pos.CENTER_LEFT);
        msgsBox.getChildren().add(hBox);
        msgsBox.getChildren().add(new Label(""));
    }

    @FXML
    private void sendMsg() throws Exception{
        if(!myMsg.getText().trim().equalsIgnoreCase("")) {

            String text = myMsg.getText();
            String name = ContextOriginator.getCurrentState().getName();

            Message msg = new Message(text, name);


            MessageOperation operation = new SendOperation(msg);
            Sender sender = new Sender(operation);
            sender.send(connection.getOutStream());
            refresh();
        }
    }

    private void makeConnection(String host, int port) {

        try {
            connection = new ChatServerConnection(host, port);
        }catch (IOException e) {
            PORT++;
            makeConnection(host, PORT);
        }

    }

    @FXML
    private void refresh() {
        msgsBox.getChildren().clear();
        MessageCollection list = messagesController.getMessageList();
        MessageCollectionIterator it = (MessageCollectionIterator) list.createIterator();
        while(it.hasNext()) {
            addMsg((Message) it.next());
        }
    }

}
