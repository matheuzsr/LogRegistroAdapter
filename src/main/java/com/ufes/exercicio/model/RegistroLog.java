package com.ufes.exercicio.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class RegistroLog {

    String tipo;
    String informacao;
    String usuario;
    String dataHora;

    public RegistroLog() {
    }

    public RegistroLog(String tipo, String informacao, String usuario) {
        this.tipo = tipo;
        this.informacao = informacao;
        this.usuario = usuario;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dataHora = LocalDateTime.now().format(formatter);
    }

    public String getTipo() {
        return tipo;
    }

    public String getInformacao() {
        return informacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDataHora() {
        return dataHora;
    }

}
