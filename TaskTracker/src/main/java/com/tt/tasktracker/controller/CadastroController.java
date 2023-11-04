package com.tt.tasktracker.controller;

import com.tt.tasktracker.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class CadastroController {
    @FXML
    private Button botaoConfirmaCadastro;

    @FXML
    private Button botaoVoltaLogin;

    @FXML
    void confirmarCadastro(MouseEvent event) {
        System.out.println("Executar algoritmo de registro de usuário");
    }

    @FXML
    void voltaTelaLogin(MouseEvent event) {
        Application.mudarTela("login");
    }
}
