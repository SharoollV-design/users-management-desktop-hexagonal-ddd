package com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper;

import com.jcaa.usersmanagement.domain.model.Estudiante;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity.EstudianteEntity;

public class EstudianteMapper {
   
    public static EstudianteEntity toEntity(Estudiante estudiante) {
        if (estudiante == null) return null;
        return new EstudianteEntity(
            estudiante.getId(),
            estudiante.getNombre(),
            estudiante.getApellido(),
            estudiante.getEmail(),
            estudiante.getCarrera()
        );
    }

 
    public static Estudiante toDomain(EstudianteEntity entity) {
        if (entity == null) return null;
        return new Estudiante(
            entity.getId(),
            entity.getNombre(),
            entity.getApellido(),
            entity.getEmail(),
            entity.getCarrera()
        );
    }
}
