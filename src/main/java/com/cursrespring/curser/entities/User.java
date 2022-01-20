package com.cursrespring.curser.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID =1L;
    private Long id;
    private String nome;
    private String phone;
    private String password;

    public User(Long id, String maria, String s, String s1, String s2) {
    }

    public User() {
        this.id = id;
        this.nome = nome;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(nome, user.nome) && Objects.equals(phone, user.phone) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, phone, password);
    }
}
