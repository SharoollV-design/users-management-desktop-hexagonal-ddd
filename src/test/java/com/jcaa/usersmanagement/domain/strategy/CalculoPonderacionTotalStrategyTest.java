package com.jcaa.usersmanagement.domain.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jcaa.usersmanagement.domain.enums.TipoExamen;
import com.jcaa.usersmanagement.domain.model.Examen;
import com.jcaa.usersmanagement.domain.valueobject.Ponderacion;

public class CalculoPonderacionTotalStrategyTest {
    @Test
    void deberiaCalcularLaPonderacionTotalCorrectamente() {
        // Arrange
        CalculoPonderacionTotalStrategy strategy = new CalculoPonderacionTotalStrategy();

        Examen examen1 = new Examen("1", "Parcial 1", "MAT", LocalDate.now(), new Ponderacion(2.0), TipoExamen.ESCRITO);
        Examen examen2 = new Examen("2", "Parcial 2", "MAT", LocalDate.now(), new Ponderacion(3.0), TipoExamen.PRACTICO);

        List<Examen> examenes = Arrays.asList(examen1, examen2);

        // Act
        double totalPonderacion = strategy.calcularAcumuladoPonderaciones(examenes); 

        // Assert
        assertEquals(5.0, totalPonderacion, 0.001);
    }
}
