package com.tt.tasktracker.controller;

import com.tt.tasktracker.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {
    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    void clickCadastrar(ActionEvent event) {
        MainApplication.mudarTela("Cadastro");
    }

    @FXML
    void clickEntrar(){
        System.out.println("Executar algoritmo de busca de usuário e senha");
    }
}
