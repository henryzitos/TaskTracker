package com.tt.tasktracker;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Stage stagePrincipal;
    private static Scene cadastroScene;
    private static Scene loginScene;

    @Override
    public void start(Stage stage) throws IOException {
        stagePrincipal = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        loginScene = scene;
        FXMLLoader fxmlLoader1 = new FXMLLoader(Application.class.getResource("cadastro.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        cadastroScene = scene1;
        stage.setScene(scene);
        stage.show();
    }

    public static void mudarTela(String tela) {
        if (tela == "cadastro"){
            stagePrincipal.setScene(cadastroScene);
        }
        if (tela == "login") {
            stagePrincipal.setScene(loginScene);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}