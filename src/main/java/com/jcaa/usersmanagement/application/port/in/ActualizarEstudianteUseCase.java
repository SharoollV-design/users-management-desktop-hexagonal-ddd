package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.Estudiante;

public interface ActualizarEstudianteUseCase {
    void actualizar(String id, Estudiante estudianteActualizado);
}
