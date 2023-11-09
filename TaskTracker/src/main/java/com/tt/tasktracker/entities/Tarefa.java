package com.tt.tasktracker.entities;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Identificador / Chave primária
    @Column
    private String nome; //Nome da tarefa
    @Column
    private String descricao; //Descrição da tarefa
    @Column
    private int dia; //Dia de fim da tarefa
    @Column
    private int mes; //Mês de fim da tarefa
    @Column
    private int ano; //Ano de fim da tarefa
    @Column
    private int hora; //Hora de término da tarefa
    @Column
    private int minuto; //Minuto de término da tarefa

    public Tarefa(String nome, String descricao, int dia, int mes, int ano, int hora, int minuto) {
        this.nome = nome;
        this.descricao = descricao;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minuto = minuto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                ", hora=" + hora +
                ", minuto=" + minuto +
                '}';
    }

    public void registrarTarefa() {

    }
}
