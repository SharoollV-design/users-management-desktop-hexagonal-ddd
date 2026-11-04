package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.Examen;
import java.util.Optional;

public interface ExamenRepositoryPort {
    void guardar(Examen examen);
    Optional<Examen> buscarPorId(Long id);
}
