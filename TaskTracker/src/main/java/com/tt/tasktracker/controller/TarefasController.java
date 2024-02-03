package com.tt.tasktracker.controller;

import com.tt.tasktracker.MainApplication;
import com.tt.tasktracker.entities.Tarefa;
import com.tt.tasktracker.entities.Usuario;
import com.tt.tasktracker.util.HibernateUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TarefasController implements Initializable {

    @FXML
    private Button botaoAdicionarTarefa;

    @FXML
    private Button botaoEditarTarefa;

    @FXML
    private Button botaoExcluirTarefa;

    @FXML
    private Button botaoLogOff;

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

    private static Usuario usuarioLogado;
    private ObservableList<Tarefa> observableListTarefas = FXCollections.observableArrayList(
    //        new Tarefa("Tarefa 1", "Descrição 1", "Categoria 1", "2022-02-10", usuarioLogado)
    );

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] tiposDeTarefas = {"Atividade", "Prova", "Trabalho", "Tarefa"};
        tipoDaTarefa.getItems().addAll(tiposDeTarefas);

        apresentarTarefas();
    }

    //Traz o usuário para o controller
    public void trazDadosUsuario(Usuario usuario) {
        //Usuário logado
        usuarioLogado = usuario;
        System.out.println(usuarioLogado);

        observableListTarefas = FXCollections.observableArrayList(usuarioLogado.getTarefas());
        System.out.println(observableListTarefas);

        //tabelaPrincipal.setItems(FXCollections.observableList(usuarioLogado.getTarefas()));

        apresentarTarefas();
    }

    public void apresentarTarefas() {
        nomeDaTarefa.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("nome"));
        descricaoDaTarefa.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("descricao"));
        categoriaDaTarefa.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("categoria"));
        dataDaTarefa.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("dataFim"));

        System.out.println(tabelaPrincipal.getItems());
        tabelaPrincipal.refresh();
    }


    @FXML
    public void addTarefa(ActionEvent event){
        String nome = digitaNomeTarefa.getText();
        String descricao = digitaDescricaoTarefa.getText();
        String categoria = tipoDaTarefa.getValue();

        LocalDate data = selecionaData.getValue();
        String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Tarefa t = new Tarefa(nome, descricao, categoria, dataFormatada, usuarioLogado);

        Session sessionRegistrarAtv = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessionRegistrarAtv.beginTransaction();
        sessionRegistrarAtv.persist(t);
        usuarioLogado.addTarefa(t);
        transaction.commit();

        System.out.println("Tarefa registrada:");
        System.out.println(t);

        apresentarTarefas();
    }

    @FXML
    void editarTarefa(ActionEvent event) {

    }

    @FXML
    void excluirTarefa(ActionEvent event) {

    }

    @FXML
    void marcarTarefaConcluida(ActionEvent event) {

    }

    @FXML
    void voltarTelaLogin(ActionEvent event) {
        digitaDescricaoTarefa.clear();
        digitaNomeTarefa.clear();
        tipoDaTarefa.setValue(null);
        selecionaData.setValue(null);
        MainApplication.mudarTela("Login");
    }
}