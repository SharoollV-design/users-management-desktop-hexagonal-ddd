package com.jcaa.usersmanagement.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.jcaa.usersmanagement.domain.exception.EstudianteInvalidoExcepcion;
import com.jcaa.usersmanagement.domain.model.Estudiante;

public class EstudianteTest {
    
    @Test
    void dadoEstudianteValido_cuandoSeCrea_entoncesPropiedadesSonCorrectas() {
        Estudiante est = new Estudiante("E01", "Sharoll", "Montoya", "smontoya@uchile.com", "Ingenieria de Software");
        
        assertEquals("E01", est.getId());
        assertEquals("Sharoll", est.getNombre());
        assertEquals("Montoya", est.getApellido());
        assertEquals("smontoya@uchile.com", est.getEmail());
        assertEquals("Ingenieria de Software", est.getCarrera());
    }

    @Test
    void dadoEmailNulo_cuandoSeCreaEstudiante_entoncesLanzaExcepcion() {
        assertThrows(EstudianteInvalidoExcepcion.class, () -> {
            new Estudiante("E01", "Sharoll", "Montoya", null, "Ingenieria de Software");
        });
    }
}
