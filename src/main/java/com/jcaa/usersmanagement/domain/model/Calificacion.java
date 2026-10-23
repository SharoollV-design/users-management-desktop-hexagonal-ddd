package com.jcaa.usersmanagement.domain.model;

import java.time.LocalDate;

public class Calificacion {
    private String id;
    private String estudianteId;
    private String subjectCode;
    private double valor; // Nota obtenida (ej. 4.5, 85.0, etc.)
    private LocalDate fechaRegistro;

    public Calificacion(String id, String estudianteId, String subjectCode, double valor, LocalDate fechaRegistro) {
        if (valor < 0 || valor > 5.0) {
            throw new IllegalArgumentException("La calificación debe estar en un rango válido.");
        }
        this.id = id;
        this.estudianteId = estudianteId;
        this.subjectCode = subjectCode;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
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

    public double getValor() { 
        return valor; 
    }

    public LocalDate getFechaRegistro() { 
        return fechaRegistro;
    }
}
