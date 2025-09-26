package org.example.lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load(), 450, 600);
        stage.setScene(scene);
        stage.setTitle("Factory Pattern - Shapes");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}