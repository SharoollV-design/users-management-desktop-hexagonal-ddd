package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.BuscarEstudianteUseCase;
import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;
import com.jcaa.usersmanagement.domain.model.Estudiante;

import java.util.Optional;

public class BuscarEstudianteService implements BuscarEstudianteUseCase {
    private final EstudianteRepositoryPort estudianteRepository;

    public BuscarEstudianteService(EstudianteRepositoryPort estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public Optional<Estudiante> buscarPorId(String id) {
        return estudianteRepository.findById(id);
    }
}
