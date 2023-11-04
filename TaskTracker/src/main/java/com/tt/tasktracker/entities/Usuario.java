package com.tt.tasktracker.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String user;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String lastName;

    public static Long idBase;

    public Usuario(String user, String password, String email, String name, String lastName) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.id = idBase++;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID =" + id +
                ", Usuário ='" + user + '\'' +
                ", Senha ='" + password + '\'' +
                ", E-Mail ='" + email + '\'' +
                ", Nome = '" + name + '\'' +
                ", Sobrenome ='" + lastName + '\'' +
                '}';
    }
}
