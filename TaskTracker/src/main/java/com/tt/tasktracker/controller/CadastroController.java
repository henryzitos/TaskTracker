package com.tt.tasktracker.controller;

import com.tt.tasktracker.MainApplication;
import com.tt.tasktracker.entities.Usuario;
import com.tt.tasktracker.util.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;

public class CadastroController {

    @FXML
    private Button botaoConfirmaCadastro;

    @FXML
    private Button botaoVoltaLogin;

    @FXML
    private TextField cadastroUser;

    @FXML
    private TextField cadastroEmail;

    @FXML
    private PasswordField cadastroSenha;

    @FXML
    private PasswordField cadastroConfirmaSenha;

    @FXML
    void confirmarCadastro(ActionEvent event) {
        String s = cadastroSenha.getText();
        String email = cadastroEmail.getText();

        if (s.equals(cadastroConfirmaSenha.getText()) && !email.isEmpty()) {
            String nome = cadastroUser.getText();
            boolean userExistente = verificaNomeExistente(nome);

            if (userExistente) {
                System.err.println("Nome de usuário já existente no banco. Cadastro não autorizado.");
            } else {
                Usuario u = new Usuario(cadastroUser.getText(), cadastroEmail.getText(), cadastroConfirmaSenha.getText());
                System.out.println("Executar adição de usuário no banco.");
                System.out.println(u);

                try (Session sessionCadastrar = HibernateUtil.getSessionFactory().openSession()) {
                    Transaction transaction = sessionCadastrar.beginTransaction();
                    sessionCadastrar.persist(u);
                    transaction.commit();

                    System.out.println("O registro foi realizado com sucesso. Novo usuário registrado.");
                    cadastroUser.clear();
                    cadastroEmail.clear();
                    cadastroSenha.clear();
                    cadastroConfirmaSenha.clear();
                    MainApplication.mudarTela("Login");
                } catch (Exception e) {
                    System.err.println("Registro não bem sucedido.");
                    System.err.println("Erro: " + e.getMessage());
                }
            }
        } else {
            if (email.isEmpty()) {
                System.err.println("O campo de e-mail está vazio. Digite um email para prosseguir.");
            } else {
                System.err.println("As senhas não estão iguais. Digite as duas senhas de forma igual.");
            }
        }
    }

    private boolean verificaNomeExistente(String nomeUsuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(u) FROM Usuario u WHERE u.user = :nome";
            Long count = session.createQuery(hql, Long.class)
                    .setParameter("nome", nomeUsuario)
                    .uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            System.err.println("Erro ao verificar usuário existente: " + e.getMessage());
            return false;
        }
    }

    @FXML
    void voltaTelaLogin(ActionEvent event) {
        cadastroUser.clear();
        cadastroEmail.clear();
        cadastroSenha.clear();
        cadastroConfirmaSenha.clear();
        MainApplication.mudarTela("Login");
    }
}
