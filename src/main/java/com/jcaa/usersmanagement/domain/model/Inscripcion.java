package com.jcaa.usersmanagement.domain.model;

import java.time.LocalDate;

public class Inscripcion {
    private String id;
    private String estudianteId;
    private String subjectCode; 
    private LocalDate fechaInscripcion;

    public Inscripcion(String id, String estudianteId, String subjectCode, LocalDate fechaInscripcion) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.subjectCode = subjectCode;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getId() {
        return id;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
}
