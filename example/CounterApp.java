package org.example;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Label;

public class CounterApp extends Application{
    private int visitors = 0;
    @Override
    public void start (Stage stage){
        Label countLabel = new Label("Посетителей: 0" + visitors);
        Button enterButton = new Button("ПРИШЁЛ");

        enterButton.setOnAction(event -> {
            visitors++;
            countLabel.setText("Посетителей: "+visitors);
        });

        Button leaveButtond = new Button("УШЁЛ");
        leaveButtond.setOnAction(actionEvent -> {
            if (visitors > 0){
                visitors--;
                countLabel.setText("Посетителей: "+visitors);
            }else {
                countLabel.setText("Посетителей: "+visitors);
            }
        });

        Button resetButton = new Button("СБРОСИТЬ");
        resetButton.setOnAction(actionEvent -> {
            visitors = 0;
            countLabel.setText("Посетителей: "+visitors);
        });

        VBox root = new VBox(12, countLabel, enterButton, leaveButtond, resetButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 360, 220);

        stage.setTitle("Счётчик посетителей");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
