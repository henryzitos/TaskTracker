package com.tt.tasktracker.entities;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private String dataFim;

    @Column
    private String categoria;

    @ManyToOne
    private Usuario usuario;

    public Tarefa(String nome, String descricao, String categoria, String dataFim, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataFim = dataFim;
        this.usuario = usuario;
    }

    public Tarefa() { }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataFim='" + dataFim + '\'' +
                ", categoria='" + categoria + '\'' +
                ", usuario=" + usuario +
                '}';
    }


}
