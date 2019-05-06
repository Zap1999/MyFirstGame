package ItemsPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ItemShopController {


    @FXML
    BorderPane mainPane;

    @FXML
    public void buyWeapon(ActionEvent event) {
        Button button = (Button) event.getSource();
        buy("WEAPON", button.getId());
    }

    @FXML
    public void buyBody(ActionEvent event) {
        Button button = (Button) event.getSource();
        buy("BODY", button.getId());
    }

    private void buy(String type, String name) {
        if ((BuyItem.buy(type, name))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("You successfully bought this item.");
            alert.setHeaderText(null);
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You already own this item.");
            alert.setHeaderText(null);
            alert.show();
        }
    }

    @FXML
    private void back() throws IOException {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("../MenuPackage/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
