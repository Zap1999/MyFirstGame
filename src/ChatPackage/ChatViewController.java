package ChatPackage;

import GamePackage.ContextOriginator;
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

        try {
            connection = new ChatServerConnection();
        }catch (IOException e) {
            System.err.println("Chat connection failed.");
            e.printStackTrace();
        }

        Message msg = new Message("Hello world!", "You");
        addMsg(msg);
        addMsg(new Message("Bye, bastard!", "qwe"));
        addMsg(new Message("vdshdbfudjksfnsldkfnsdklfndslkfnsdlkfndskflsdf", "Someguy"));
    }

    @FXML
    private void back() throws IOException {
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
    private void sendMsg() {
        if(!myMsg.getText().trim().equalsIgnoreCase("")) {

            String text = myMsg.getText();
            String name = ContextOriginator.getCurrentState().getName();

            Message msg = new Message(text, name);

            Sender sender = new Sender(msg);
            sender.send(connection.getOutStream());

        }
    }

}
