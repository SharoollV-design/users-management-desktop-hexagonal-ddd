package com.jcaa.usersmanagement.domain.strategy;

import java.util.List;
import com.jcaa.usersmanagement.domain.model.Examen;

public class CalculoPonderacionTotalStrategy implements CalculoNotaStrategy {
    
    @Override
    public double calcularAcumuladoPonderaciones(List<Examen> examenesDeAsignatura) {
        if (examenesDeAsignatura == null || examenesDeAsignatura.isEmpty()) {
            return 0.0;
        }

        return examenesDeAsignatura.stream()
            .mapToDouble(Examen::getPonderacion)
            .sum();
    }
}
