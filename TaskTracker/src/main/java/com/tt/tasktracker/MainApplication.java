package com.tt.tasktracker;

import com.tt.tasktracker.controller.TarefasController;
import com.tt.tasktracker.entities.Usuario;
import com.tt.tasktracker.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;

public class MainApplication extends Application {
    private static Stage stagePrincipal;
    private static Scene loginScene;
    private static Scene cadastroScene;
    private static Scene tarefasScene;
//    private static Scene perfilScene;

    @Override
    public void start(Stage stage) throws IOException {
        stagePrincipal = stage;

        FXMLLoader fxmlLoaderLogin = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene sceneLogin = new Scene(fxmlLoaderLogin.load());
        loginScene = sceneLogin;

        FXMLLoader fxmlLoaderCadastro = new FXMLLoader(MainApplication.class.getResource("cadastro.fxml"));
        Scene sceneCadastro = new Scene(fxmlLoaderCadastro.load());
        cadastroScene = sceneCadastro;

        FXMLLoader fxmlLoaderTarefas = new FXMLLoader(MainApplication.class.getResource("tarefas.fxml"));
        Scene sceneTarefas = new Scene(fxmlLoaderTarefas.load());
        tarefasScene = sceneTarefas;

//        FXMLLoader fxmlLoaderPerfil = new FXMLLoader(MainApplication.class.getResource("perfil.fxml"));
//        Scene scenePerfil = new Scene(fxmlLoaderPerfil.load());
//        perfilScene = scenePerfil;

        Session session = HibernateUtil.getSessionFactory().openSession();
        stage.setTitle("Task Tracker");
        stage.setScene(sceneLogin);
        stage.show();
    }

    public static void mudarTela(String tela) {
        if (tela.equals("Login")) {
            stagePrincipal.setScene(loginScene);
        }

        if (tela.equals("Cadastro")){
            stagePrincipal.setScene(cadastroScene);
        }

        if (tela.equals("Tarefas")){
            stagePrincipal.setScene(tarefasScene);
        }

//        if (tela.equals("Perfil")) {
//            stagePrincipal.setScene(perfilScene);
//        }
    }

    public static void main(String[] args) {
        launch();
    }
}