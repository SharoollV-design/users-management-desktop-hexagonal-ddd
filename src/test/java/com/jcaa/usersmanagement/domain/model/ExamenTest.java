package com.jcaa.usersmanagement.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.jcaa.usersmanagement.domain.enums.TipoExamen;
import com.jcaa.usersmanagement.domain.valueobject.Ponderacion;

public class ExamenTest {

    @Test
    void deberiaCrearExamenCorrectamenteConSusAtributos() {
       
        String id = "uuid-123";
        String titulo = "Parcial de Matemáticas";
        String subjectCode = "MAT-101";
        LocalDate fecha = LocalDate.of(2026, 5, 10);
        Ponderacion ponderacion = new Ponderacion(3.0);
        TipoExamen tipo = TipoExamen.ESCRITO;

     
        Examen examen = new Examen(id, titulo, subjectCode, fecha, ponderacion, tipo);

        
        assertEquals(id, examen.getId());
        assertEquals(titulo, examen.getTitulo());
        assertEquals(subjectCode, examen.getSubjectCode());
        assertEquals(fecha, examen.getFecha());
        assertEquals(3.0, examen.getPonderacion());
        assertEquals(tipo, examen.getTipoExamen());
    }
}
