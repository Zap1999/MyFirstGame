package chat;

import game.Context;
import game.ContextOriginator;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;


public class ChatViewController {
    private static int PORT;
    private ChatServerConnection connection;

    private Stage stage;
    @FXML
    BorderPane mainPane;
    @FXML
    VBox msgsBox;
    @FXML
    TextArea myMsg;

    @FXML
    public void initialize() {

        int port = ContextOriginator.getCurrentState().getPort();
        if (port > 0) {
            PORT = port;
        }
        else {
            PORT = 7777;
        }
        makeConnection("localhost", PORT);
        PORT++;
        ContextOriginator.getCurrentState().setPort(PORT);
        new MessagesStatus(
                data->{
                    Platform.runLater(() -> {
                        msgsBox.getChildren().clear();
                        for(Message m : data) {
                            addMsg(m);
                        }
                    }
                    );
                },
                connection, this);
    }

    @FXML
    private void back() throws IOException {
        connection.close();
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("../menu/MainMenu.fxml"));
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
    private void sendMsg() {
        String text = myMsg.getText().trim();
        if (!text.equalsIgnoreCase("") && !isDelereOperation(text)) {

            String name = ContextOriginator.getCurrentState().getName();

            Message msg = new Message(text, name);

            MessageOperation operation = new SendOperation(msg);
            Sender sender = new Sender(operation);
            sender.send(connection.getOutStream());
            myMsg.clear();

        } else if (isDelereOperation(text)) {
            deleteMsg(text);
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

    private void deleteMsg(String text) {
        text = text.replace("/d", "");
        text = text.trim();
        Message msg = new Message(text, ContextOriginator.getCurrentState().getName());
        DeleteOperation o = new DeleteOperation(msg);
        Sender sender = new Sender(o);
        sender.send(connection.getOutStream());
    }

    private boolean isDelereOperation(String text) {
        String[] splitted = text.split(" ");
        if (splitted[0].equalsIgnoreCase("/d")) {
            return true;
        } else {
            return false;
        }
    }

}
