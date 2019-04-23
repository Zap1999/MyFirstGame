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
    public void buyItem(ActionEvent event) {
        Button button = (Button) event.getSource();
        if ((BuyItem.buy("WEAPON", button.getId()))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("You bought this item.");
            alert.setHeaderText(null);
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You already have this item.");
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
