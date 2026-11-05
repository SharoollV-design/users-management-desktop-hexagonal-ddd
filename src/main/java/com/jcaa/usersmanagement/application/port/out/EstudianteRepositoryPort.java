package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.Estudiante;
import java.util.Optional;

public interface EstudianteRepositoryPort {
    void save(Estudiante estudiante);
    Optional<Estudiante> findById(String id);
    Optional<Estudiante> findByEmail(String email);
}
