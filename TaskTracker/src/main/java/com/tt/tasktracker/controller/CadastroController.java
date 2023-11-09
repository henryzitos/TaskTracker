package com.tt.tasktracker.controller;

import com.tt.tasktracker.MainApplication;
import com.tt.tasktracker.entities.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
            Usuario u = new Usuario(cadastroUser.getText(), cadastroConfirmaSenha.getText(), cadastroEmail.getText());
            System.out.println("Executar adição do usuário.");
        } else {
            System.out.println("Exibir mensagem de erro; As senhas não estão iguais.");
        }
    }

    @FXML
    void voltaTelaLogin(ActionEvent event) {
        MainApplication.mudarTela("Login");
    }

}
