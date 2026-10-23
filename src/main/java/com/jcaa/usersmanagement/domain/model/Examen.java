package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.valueobject.Ponderacion;
import java.time.LocalDate;

public class Examen {
    private String id;
    private String titulo;
    private String subjectCode; // Código de la asignatura a la que pertenece
    private LocalDate fecha;
    private com.jcaa.usersmanagement.domain.valueobject.Ponderacion ponderacion; // Porcentaje de la nota final (ej. 30.0)

    public Examen(String id, String titulo, String subjectCode, LocalDate fecha, Ponderacion ponderacion) {
        this.id = id;
        this.titulo = titulo;
        this.subjectCode = subjectCode;
        this.fecha = fecha;
        this.ponderacion = ponderacion;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getPonderacion() {
        return ponderacion.getValor();
    }
}
