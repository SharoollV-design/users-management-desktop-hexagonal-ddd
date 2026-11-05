package com.jcaa.usersmanagement.domain.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PonderacionTest {
    
    @Test
    void deberiaCrearPonderacionValida() {

        Ponderacion ponderacion = new Ponderacion(4.5);

        assertEquals(4.5, ponderacion.getValor());
    }

    @Test
    void deberiaLanzarExcepcionSiPonderacionEsMayorA100() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Ponderacion(120.0);
        });

    }

    @Test
    void deberiaLanzarExcepcionSiPonderacionEsNegativa() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Ponderacion(-10.0);
        });

    }
}
