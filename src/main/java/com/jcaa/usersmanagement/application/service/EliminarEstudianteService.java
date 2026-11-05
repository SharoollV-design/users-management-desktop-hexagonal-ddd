package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.EliminarEstudianteUseCase;
import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;
import com.jcaa.usersmanagement.domain.exception.EstudianteInvalidoExcepcion;

public class EliminarEstudianteService implements EliminarEstudianteUseCase {
    
    private final EstudianteRepositoryPort estudianteRepository;

    public EliminarEstudianteService(EstudianteRepositoryPort estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public void eliminar(String id) {
        if (estudianteRepository.findById(id).isEmpty()) {
            throw new EstudianteInvalidoExcepcion("No se puede eliminar. No existe un estudiante con el ID: " + id);
        }

        estudianteRepository.deleteById(id);
    }

}
