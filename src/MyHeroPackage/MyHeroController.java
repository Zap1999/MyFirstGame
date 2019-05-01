package MyHeroPackage;

import GamePackage.Context;
import GamePackage.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MyHeroController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private ImageView heroView;

    @FXML
    private Label attack;
    @FXML
    private Label hp;
    @FXML
    private Label money;

    private Stage stage;

    @FXML
    public void initialize() {
        try {
            Game game = Context.loadGame();
            attack.setText(String.valueOf(game.getHeroAttck()));
            hp.setText(String.valueOf(game.getHeroHp()));
            money.setText("10000$");
            heroView.setImage(new Image(game.getViewPath(), 300, 400, false, true));
        }
        catch (Exception e) {
            System.err.println("Loading hero view error.");
            e.printStackTrace();
        }
    }

    @FXML
    private void back() throws IOException {
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("../MenuPackage/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
