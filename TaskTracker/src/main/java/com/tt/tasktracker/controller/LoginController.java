package com.tt.tasktracker.controller;

import com.tt.tasktracker.Application;
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
        Application.mudarTela("cadastro");
    }

    @FXML
    void clickEntrar(ActionEvent event){
        System.out.println("Executar algoritmo de busca de usuário e senha");
    }
}
