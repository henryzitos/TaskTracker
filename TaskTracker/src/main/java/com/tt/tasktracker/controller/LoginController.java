package com.tt.tasktracker.controller;

import com.tt.tasktracker.MainApplication;
import com.tt.tasktracker.entities.Usuario;
import com.tt.tasktracker.util.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private PasswordField loginSenha;

    @FXML
    private TextField loginUsuario;

    @FXML
    void clickCadastrar(ActionEvent event) throws IOException {
        MainApplication.mudarTela("Cadastro", null);
    }

    @FXML
    void clickEntrar(ActionEvent event){
        System.out.println("Executar algoritmo de busca de usuário e senha.");

        String nome = loginUsuario.getText();
        String senha = loginSenha.getText();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consulta HQL para verificar se o nome de usuário existe
            String hql = "FROM Usuario u WHERE u.user = :nome";
            Query<Usuario> query = session.createQuery(hql, Usuario.class);
            query.setParameter("nome", nome);
            Usuario usuario = query.uniqueResult();

            if (usuario != null && usuario.getSenha().equals(senha)) {
                System.out.println("Credenciais batem.");
                MainApplication.mudarTela("Tarefas", usuario);
            } else {
                System.err.println("Senha e usuário não batem.");
            }
        } catch (Exception e) {
            System.err.println("Algo de errado não está certo: " + e.getMessage());
        }
    }
}
