package com.tt.tasktracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    private static Stage stagePrincipal;
    private static Scene cadastroScene;
    private static Scene loginScene;

    @Override
    public void start(Stage stage) throws IOException {
        stagePrincipal = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        loginScene = scene;
        FXMLLoader fxmlLoader1 = new FXMLLoader(MainApplication.class.getResource("cadastro.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        cadastroScene = scene1;
        stage.setScene(scene);
        stage.show();
    }

    public static void mudarTela(String tela) {
        if (tela == "Cadastro"){
            stagePrincipal.setScene(cadastroScene);
        }
        if (tela == "Login") {
            stagePrincipal.setScene(loginScene);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}