package com.rafademetrio.demo.usuario.controller.exception;

public class StandardError {

    private Integer status;
    private Long timeStamp;
    private String mensagem;

    public StandardError() {
    }

    public StandardError(Integer status, Long timeStamp, String mensagem) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.mensagem = mensagem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
