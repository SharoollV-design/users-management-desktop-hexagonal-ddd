package com.jcaa.usersmanagement.domain.strategy;

import java.util.List;
import com.jcaa.usersmanagement.domain.model.Examen;

public interface CalculoNotaStrategy {

    double calcularAcumuladoPonderaciones(List<Examen> examenesDeAsignatura);

}