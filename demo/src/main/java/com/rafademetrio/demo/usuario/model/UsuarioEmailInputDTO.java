package com.rafademetrio.demo.usuario.model;

import java.math.BigInteger;

public class UsuarioEmailInputDTO {

    Integer id;

    String email;

    public UsuarioEmailInputDTO() {
    }

    public UsuarioEmailInputDTO(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
