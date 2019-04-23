package MenuPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    Stage stage;

    @FXML
    private BorderPane mainPane;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    //TODO
    /*@FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.close();
    }*/

    @FXML
    private void toHero () throws IOException {
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/MyHeroPackage/MyHero.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void toMissions () throws IOException {
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/MissionsPackage/MissionBattle.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void toShop() throws IOException {
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/ItemsPackage/ItemShop.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
