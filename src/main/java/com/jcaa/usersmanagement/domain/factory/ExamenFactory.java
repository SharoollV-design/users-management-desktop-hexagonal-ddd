package com.jcaa.usersmanagement.domain.factory;

import java.time.LocalDate;
import java.util.UUID;

import com.jcaa.usersmanagement.domain.enums.TipoExamen;
import com.jcaa.usersmanagement.domain.model.Examen;
import com.jcaa.usersmanagement.domain.valueobject.Ponderacion;

public class ExamenFactory {
    
    public Examen crearExamen(String id, String titulo, String subjectCode, LocalDate fecha, Ponderacion ponderacion, TipoExamen tipoExamen) {
        
        String idGenerado = UUID.randomUUID().toString();
    
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título del examen no puede estar vacío.");
        }

        if (subjectCode == null || subjectCode.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de la asignatura (subjectCode) es obligatorio.");
        }

        return new Examen(
                idGenerado,
                titulo,
                subjectCode,
                fecha,
                ponderacion,
                tipoExamen
        );
    }
}
