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

import java.io.IOException;

public class CadastroController {

    @FXML
    private Button botaoConfirmaCadastro;

    @FXML
    private Button botaoVoltaLogin;

    @FXML
    private PasswordField cadastroConfirmaSenha;

    @FXML
    private TextField cadastroEmail;

    @FXML
    private PasswordField cadastroSenha;

    @FXML
    private TextField cadastroUser;

    @FXML
    void confirmarCadastro(ActionEvent event) {
        String s = cadastroSenha.getText();
        if (s.equals(cadastroConfirmaSenha.getText())) {
            Usuario u = new Usuario(cadastroUser.getText(), cadastroEmail.getText(), cadastroConfirmaSenha.getText());
            System.out.println("Executar adição do usuário no banco.");
            System.out.println(u);

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.persist(u);
                transaction.commit();

                System.out.println("Sucesso!");
                MainApplication.mudarTela("Login", null);
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("Algo de errado não está certo. Método salvarEntidade");
                System.err.println("Registro não bem sucedido, tente novamente");
            }
        } else {
            System.err.println("As senhas não estão iguais.");
        }
    }

    @FXML
    void voltaTelaLogin(ActionEvent event) throws IOException {
        MainApplication.mudarTela("Login", null);
    }
}
