package com.tt.tasktracker.controller;

import com.tt.tasktracker.entities.Tarefa;
import com.tt.tasktracker.entities.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TarefasController implements Initializable {
    @FXML
    private Button botaoAdicionarTarefa;

    @FXML
    private Button botaoEditarTarefa;

    @FXML
    private Button botaoExcluirTarefa;

    @FXML
    private TextField digitaDescricaoTarefa;

    @FXML
    private TextField digitaNomeTarefa;

    @FXML
    private ChoiceBox<String> tipoDaTarefa;

    @FXML
    private DatePicker selecionaData;

    @FXML
    private TableView<Tarefa> tabelaPrincipal;

    @FXML
    private TableColumn<Tarefa, String> nomeDaTarefa;

    @FXML
    private TableColumn<Tarefa, String> descricaoDaTarefa;

    @FXML
    private TableColumn<Tarefa, String> categoriaDaTarefa;

    @FXML
    private TableColumn<Tarefa, String> dataDaTarefa;

    private String[] tiposDeTarefas = {"Atividade", "Prova", "Trabalho", "Tarefa"};

    private Usuario usuarioLogado;

    public void initData(Usuario usuario) {
        this.usuarioLogado = usuario;
        // Use o usuário para adicionar tarefas
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tipoDaTarefa.getItems().addAll(tiposDeTarefas);

        nomeDaTarefa.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("nome"));
        descricaoDaTarefa.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("descricao"));
        categoriaDaTarefa.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("categoria"));
        dataDaTarefa.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("dataFim"));
    }

    public void addTarefa(ActionEvent event){
        String nome = digitaNomeTarefa.getText();
        String descricao = digitaDescricaoTarefa.getText();
        String categoria = tipoDaTarefa.getValue();

        LocalDate data = selecionaData.getValue();
        String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Tarefa t = new Tarefa(nome, descricao, categoria, dataFormatada, usuarioLogado);

        usuarioLogado.addTarefa(t);
    }

}
