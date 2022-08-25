package com.rafademetrio.demo.receitas.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ReceitaInputDTO {
   @NotNull
   @Min(0)
   Double valor;

   @NotNull
   @Min(0)
   Integer UsuarioId;

    public ReceitaInputDTO() {
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        UsuarioId = usuarioId;
    }
}
