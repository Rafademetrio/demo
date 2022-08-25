package com.rafademetrio.demo.despesas.model;

import java.time.LocalDate;

public class DespesaOutputDTO {

    Double valor;

    LocalDate data;

    Integer usuarioId;

    public DespesaOutputDTO() {
    }

    public DespesaOutputDTO(Despesa despesa){
        this.valor = despesa.getValor();
        this.data = despesa.getData();
        this.usuarioId = despesa.getUsuario().getId();
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
