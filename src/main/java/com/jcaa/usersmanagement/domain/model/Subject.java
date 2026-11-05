package com.jcaa.usersmanagement.domain.model;

public class Subject {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int creditos;
    private int anioAcademico;
    private String semestre;
    private String horarioClases;

    public Subject(String codigo, String nombre, String descripcion, int creditos, int anioAcademico, String semestre,
            String horarioClases) throws IllegalAccessException {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalAccessException("El codigo de la asignatura no puede estar vacío");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.anioAcademico = anioAcademico;
        this.semestre = semestre;
        this.horarioClases = horarioClases;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getAnioAcademico() {
        return anioAcademico;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getHorarioClases() {
        return horarioClases;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setAnioAcademico(int anioAcademico) {
        this.anioAcademico = anioAcademico;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setHorarioClases(String horarioClases) {
        this.horarioClases = horarioClases;
    }

    @Override
    public String toString() {
        return "Asignatura [" + codigo + "] " + nombre + " (Semestre: " + semestre + ")";
    }

}
