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
    private ImageView weaponImg;

    @FXML
    private Label weaponName;

    private Stage stage;

    @FXML
    public void initialize() {
        try {
            Game game = Context.loadGame();
            String weapon = game.getWeapon().getName();
            weaponName.setText(weapon);
            weaponImg.setImage(new Image("\\img\\weapon_" + weapon + ".png", 64, 64, false, true));
        }
        catch (Exception e) {
            System.out.println("My hero init failed.");
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
