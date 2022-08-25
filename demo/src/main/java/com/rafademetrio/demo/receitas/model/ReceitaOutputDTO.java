package com.rafademetrio.demo.receitas.model;

import java.time.LocalDate;

public class ReceitaOutputDTO {
    Double valor;

    Integer usuarioId;

    LocalDate data;

    public ReceitaOutputDTO() {
    }

    public ReceitaOutputDTO(Receita receita){
        this.valor = receita.getValor();
        this.data = receita.getData();
        this.usuarioId = receita.getUsuario().getId();
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
