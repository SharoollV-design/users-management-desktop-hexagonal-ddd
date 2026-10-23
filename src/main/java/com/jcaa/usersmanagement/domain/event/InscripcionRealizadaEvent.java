package com.jcaa.usersmanagement.domain.event;

import java.time.LocalDateTime;

public class InscripcionRealizadaEvent {
    private final String inscripcionId;
    private final LocalDateTime fechaOcurrencia;

    public InscripcionRealizadaEvent (String inscripcionId) {
        this.inscripcionId = inscripcionId;
        this.fechaOcurrencia = LocalDateTime.now();
    }

    public String getInscripcionId(){
        return inscripcionId;
    }

    public LocalDateTime getFechaOcurrencia(){
        return fechaOcurrencia;
    }
}
