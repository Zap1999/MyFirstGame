package StartPackage;

import DB.DBFacade;
import GamePackage.ContextOriginator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;


public class LoginController {

    @FXML
    TextField name;
    @FXML
    PasswordField pass;
    @FXML
    BorderPane mainPane;

    private Stage stage;

    @FXML
    public void logIn() throws IOException{

        if(name.getText().trim().equals("") || pass.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid form data.");
            alert.setTitle("Coolest game ever");
            alert.setHeaderText(null);
            alert.show();
        }

        DBFacade login = new DBFacade(name.getText(), pass.getText());
        if(login.logIn()) {
            loggedIn();
        }
        else {
            notLoggedIn();
        }

    }

    @FXML
    public void gotoRegister() throws IOException{
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/StartPackage/RegisterForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void loggedIn() throws IOException {
        ContextOriginator.getCurrentState().setName(name.getText());
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/MenuPackage/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void notLoggedIn() throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid login data.");
        alert.setTitle("Coolest game ever");
        alert.setHeaderText(null);
        ButtonType register = new ButtonType("Register");
        ButtonType onceMore = new ButtonType("Once more");
        alert.getButtonTypes().addAll(register, onceMore);
        Optional<ButtonType> result = alert.showAndWait();

        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        if (result.get() == onceMore)
            root = (BorderPane) FXMLLoader.load(getClass().getResource("/StartPackage/LogInForm.fxml"));

        else
            root = (BorderPane) FXMLLoader.load(getClass().getResource("/StartPackage/RegisterForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void test() throws IOException {
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/MenuPackage/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
