package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.exception.EstudianteInvalidoExcepcion;

public class Estudiante {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String carrera;

    public Estudiante(String id, String nombre, String apellido, String email, String carrera) {
        
        if (email == null || email.trim().isEmpty()) {
        throw new EstudianteInvalidoExcepcion("El email no puede ser nulo o vacío");
        }
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.carrera = carrera;
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

    public String getCarrera() {
        return carrera;
    }
}
