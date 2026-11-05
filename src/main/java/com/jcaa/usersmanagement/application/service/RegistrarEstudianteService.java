package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.RegistrarEstudianteUseCase;
import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;
import com.jcaa.usersmanagement.domain.exception.EstudianteInvalidoExcepcion;
import com.jcaa.usersmanagement.domain.model.Estudiante;

public class RegistrarEstudianteService implements RegistrarEstudianteUseCase {
   private final EstudianteRepositoryPort estudianteRepository;

    public RegistrarEstudianteService(EstudianteRepositoryPort estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public void registrar(Estudiante estudiante) {
        if (estudianteRepository.findById(estudiante.getId()).isPresent()) {
            throw new EstudianteInvalidoExcepcion("Ya existe un estudiante registrado con el ID: " + estudiante.getId());
        }
        if (estudianteRepository.findByEmail(estudiante.getEmail()).isPresent()) {
            throw new EstudianteInvalidoExcepcion("Ya existe un estudiante registrado con el correo: " + estudiante.getEmail());
        }

        estudianteRepository.save(estudiante);
        System.out.println("Estudiante registrado exitosamente: " + estudiante.getNombre() + " " + estudiante.getApellido());
    }
}
