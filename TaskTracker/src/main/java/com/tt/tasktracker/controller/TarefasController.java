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
    private static ObservableList<Tarefa> observableListTarefas;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] tiposDeTarefas = {"Atividade", "Prova", "Trabalho", "Tarefa"};
        tipoDaTarefa.getItems().addAll(tiposDeTarefas);
    }

    //Traz o usuário para o controller
    public void trazDadosUsuario(Usuario usuario) {
        //Usuário logado
        usuarioLogado = usuario;
        System.out.println(usuarioLogado);

        List<Tarefa> listaDeTarefas = usuarioLogado.getTarefas();
        observableListTarefas = FXCollections.observableArrayList(listaDeTarefas);
        System.out.println(observableListTarefas);

        apresentarTarefas();
    }

    public void apresentarTarefas(){
        // Vincular cada propriedade à sua respectiva coluna
//        nomeDaTarefa.setCellValueFactory(new PropertyValueFactory<>("nome"));
//        descricaoDaTarefa.setCellValueFactory(new PropertyValueFactory<>("descricao"));
//        categoriaDaTarefa.setCellValueFactory(new PropertyValueFactory<>("categoria"));
//        dataDaTarefa.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
        nomeDaTarefa.setCellValueFactory(cellData -> {
            Tarefa tarefa = cellData.getValue();
            StringProperty nome = new SimpleStringProperty(tarefa.getNome());
            return nome;
        });

        descricaoDaTarefa.setCellValueFactory(cellData -> {
            Tarefa tarefa = cellData.getValue();
            StringProperty descricao = new SimpleStringProperty(tarefa.getDescricao());
            return descricao;
        });

        categoriaDaTarefa.setCellValueFactory(cellData -> {
            Tarefa tarefa = cellData.getValue();
            StringProperty categoria = new SimpleStringProperty(tarefa.getCategoria());
            return categoria;
        });

        dataDaTarefa.setCellValueFactory(cellData -> {
            Tarefa tarefa = cellData.getValue();
            StringProperty dataFim = new SimpleStringProperty(tarefa.getDataFim());
            return dataFim;
        });

        // Definir a lista de itens na tabela
        tabelaPrincipal.setItems(observableListTarefas);
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

        tabelaPrincipal.refresh();
        System.out.println(t);
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
