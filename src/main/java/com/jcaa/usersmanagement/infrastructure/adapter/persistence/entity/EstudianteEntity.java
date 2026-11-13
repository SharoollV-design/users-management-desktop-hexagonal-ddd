package com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity;

public class EstudianteEntity {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String carrera;

    public EstudianteEntity(String id, String nombre, String apellido, String email, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.carrera = carrera;
    }

    // Getters y Setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getCarrera() { return carrera; }
}
