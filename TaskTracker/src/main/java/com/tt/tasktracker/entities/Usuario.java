package com.tt.tasktracker.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Identificador / Chave primária
    @Column
    private String usuario; //Usuário / @ do usuário
    @Column
    private String senha; //Senha do usuário
    @Column
    private String email; //Email do usuário
    @Column
    private String nome; //Nome do usuário
    @Column
    private String sobrenome; //Sobrenome do usuário
    @Column
    private List<Tarefa> tarefas = new ArrayList<>(); //Lista de tarefas do usuário
    @Column
    private int quantidadeAcesso = 0;

    public void adicionarTarefa(Tarefa t){
        this.tarefas.add(t);
    }

    public Usuario(String usuario, String senha, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID =" + id +
                ", Usuário ='" + usuario + '\'' +
                ", Senha ='" + senha + '\'' +
                ", E-Mail ='" + email + '\'' +
                ", Nome = '" + nome + '\'' +
                ", Sobrenome ='" + sobrenome + '\'' +
                '}';
    }
}
