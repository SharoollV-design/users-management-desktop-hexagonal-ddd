package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.ActualizarEstudianteUseCase;
import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;
import com.jcaa.usersmanagement.domain.exception.EstudianteInvalidoExcepcion;
import com.jcaa.usersmanagement.domain.model.Estudiante;

public class ActualizarEstudianteService implements ActualizarEstudianteUseCase {
    private final EstudianteRepositoryPort estudianteRepository;

    public ActualizarEstudianteService(EstudianteRepositoryPort estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public void actualizar(String id, Estudiante estudianteActualizado) {
        if (estudianteRepository.findById(id).isEmpty()) {
            throw new EstudianteInvalidoExcepcion("No se puede actualizar. No existe un estudiante con el ID: " + id);
        }

        estudianteRepository.save(estudianteActualizado);
    }
}