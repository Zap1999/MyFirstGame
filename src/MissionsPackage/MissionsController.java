package MissionsPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

public class MissionsController {

    private MissionBattleConnector connector;

    private char difficulty;
    private int mission;
    private boolean boss = false;

    @FXML
    private BorderPane mainPane;

    private Stage stage;

    @FXML
    private void back() throws IOException {
        stage = (Stage) mainPane.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("/MenuPackage/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public void startMission(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        String split[] = buttonText.split(" ");
        difficulty = split[0].toCharArray()[0];
        mission = Integer.parseInt(split[1]);
        if(split.length > 2)
            boss = true;
        connector.startMission();
    }

    @FXML
    public void startSpecialMission() {
        difficulty = 'A';
        mission=0;
        boss=true;
        connector.startMission();
    }

    public char getDifficulty() { return difficulty; }

    public int getMission() { return this.mission; }

    public boolean isBoss() { return this.boss; }

    public void init(MissionBattleConnector connector) {
        this.connector = connector;
    }
}
