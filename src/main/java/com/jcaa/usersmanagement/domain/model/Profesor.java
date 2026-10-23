package com.jcaa.usersmanagement.domain.model;

public class Profesor {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String departamento;

    public Profesor(String id, String nombre, String apellido, String email, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.departamento = departamento;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartamento() {
        return departamento;
    }
}
