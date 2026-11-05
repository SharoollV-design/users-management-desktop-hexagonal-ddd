package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.Estudiante;
import java.util.Optional;

public interface BuscarEstudianteUseCase {
    Optional<Estudiante> buscarPorId(String id);
}
