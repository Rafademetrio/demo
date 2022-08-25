package com.rafademetrio.demo.despesas.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class DespesaInputDTO {

    @NotNull
    @Min(0)
    private Double valor;

    @NotNull
    @Min(0)
    private Integer usuarioId;

    public DespesaInputDTO() {
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
