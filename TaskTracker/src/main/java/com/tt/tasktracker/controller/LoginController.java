package com.tt.tasktracker.controller;

import com.tt.tasktracker.MainApplication;
import com.tt.tasktracker.entities.Usuario;
import com.tt.tasktracker.util.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    private TextField loginUsuario;

    @FXML
    private PasswordField loginSenha;

    @FXML
    void clickCadastrar(ActionEvent event) throws IOException {
        loginUsuario.clear();
        loginSenha.clear();
        MainApplication.mudarTela("Cadastro");
    }

    @FXML
    void clickEntrar(ActionEvent event){
        System.out.println("Executar algoritmo de busca de usuário e senha.");

        String nome = loginUsuario.getText();
        String senha = loginSenha.getText();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consulta HQL para verificar se o nome de usuário está no banco
            String hql = "FROM Usuario u WHERE u.user = :nome";
            Query<Usuario> query = session.createQuery(hql, Usuario.class);
            query.setParameter("nome", nome);
            Usuario usuario = query.uniqueResult();

            if (nome != null && senha != null) {
                if (usuario != null && usuario.getSenha().equals(senha)) {
                    System.out.println("Credenciais batem.");
                    FXMLLoader fxmlLoaderTarefas = new FXMLLoader(MainApplication.class.getResource("tarefas.fxml"));
                    Scene sceneTarefas = new Scene(fxmlLoaderTarefas.load());
                    TarefasController tarefasController = fxmlLoaderTarefas.getController();
                    tarefasController.trazDadosUsuario(usuario); // Passando o usuário para o controlador de Tarefas
                    loginUsuario.clear();
                    loginSenha.clear();
                    MainApplication.mudarTela("Tarefas");
                } else {
                    System.err.println("Senha e usuário não batem.");
                }
            } else {
                System.err.println("Campos nulos! Não é possível fazer login.");
            }
        } catch (Exception e) {
            System.err.println("Algo de errado não está certo: " + e.getMessage());
        }
    }
}
