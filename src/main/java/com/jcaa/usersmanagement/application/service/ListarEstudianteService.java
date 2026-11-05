package com.jcaa.usersmanagement.application.service;

import java.util.List;

import com.jcaa.usersmanagement.application.port.in.ListarEstudianteUseCase;
import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;
import com.jcaa.usersmanagement.domain.model.Estudiante;

public class ListarEstudianteService implements ListarEstudianteUseCase {
    private final EstudianteRepositoryPort estudianteRepository;

    public ListarEstudianteService(EstudianteRepositoryPort estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }
    
}