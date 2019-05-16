package start;

import db.DBFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class RegisterController {

    @FXML
    BorderPane mainPane;
    @FXML
    TextField user;
    @FXML
    PasswordField pass1;
    @FXML
    PasswordField pass2;

    Stage stage;

    @FXML
    public void register() throws IOException{
        if(!(pass1.getText().equals(pass2.getText()))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Content of fields for passwords\n do not match.");
            alert.setTitle("Coolest game ever");
            alert.setHeaderText("Passwords do not match!");
            alert.show();
        }
        else if(user.getText().trim().equals("") || pass1.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid form data.");
            alert.setTitle("Coolest game ever");
            alert.setHeaderText(null);
            alert.show();
        }
        else {
            DBFacade register = new DBFacade(user.getText(), pass1.getText());
            if (register.register()) {
                registered();
            }
            else {
                notRegistered();
            }
        }
    }

    @FXML
    public void backToLogin() throws IOException {
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/start/LogInForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void registered() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registered successfully!");
        alert.setTitle("Coolest game ever");
        alert.show();

        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/start/LogInForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void notRegistered() throws IOException{
        Alert alert = new Alert(Alert.AlertType.ERROR, "Registration failed");
        alert.setTitle("Coolest game ever");
        alert.show();

        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/start/RegisterForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
