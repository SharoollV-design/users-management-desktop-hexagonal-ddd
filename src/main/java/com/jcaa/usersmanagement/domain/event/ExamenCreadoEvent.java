package com.jcaa.usersmanagement.domain.event;

import java.time.LocalDateTime;

public class ExamenCreadoEvent {
    private final String examenId;
    private final String titulo;
    private final LocalDateTime fechaOcurrencia;

    public ExamenCreadoEvent(String examenId, String titulo) {
        this.examenId = examenId;
        this.titulo = titulo;
        this.fechaOcurrencia = LocalDateTime.now();
    }

    public String getExamenId(){
        return examenId;
    }

    public String getTitulo(){
        return titulo;
    }

    public LocalDateTime getFechaOcurrencia(){
        return fechaOcurrencia;
    }
}
