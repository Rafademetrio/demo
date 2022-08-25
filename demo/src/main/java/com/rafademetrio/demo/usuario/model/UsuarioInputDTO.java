package com.rafademetrio.demo.usuario.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioInputDTO {

    private Integer id;
    @NotBlank
    @Size(min = 2, message = "Nome precisa ter pelo menos 2 letras.")
    private String nome;

    @Email
    private String email;

    @NotBlank
    @Size(min = 4, message = "Senha precisa ter pelo menos 4 caracteres.")
    private String senha;

    private Double saldo;

    public UsuarioInputDTO() {
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
