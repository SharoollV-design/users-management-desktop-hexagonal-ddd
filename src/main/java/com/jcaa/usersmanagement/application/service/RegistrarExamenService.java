package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.RegistrarExamenUseCase;
import com.jcaa.usersmanagement.application.port.out.ExamenRepositoryPort;
import com.jcaa.usersmanagement.domain.exception.ExamenInvalidoExcepcion;
import com.jcaa.usersmanagement.domain.model.Examen;

public class RegistrarExamenService implements RegistrarExamenUseCase{
    private final ExamenRepositoryPort examenRepositoryPort;

    // Inyección de dependencias por constructor
    public RegistrarExamenService(ExamenRepositoryPort examenRepositoryPort) {
        this.examenRepositoryPort = examenRepositoryPort;
    }

    @Override
    public void registrar(Examen examen) {
        if (examen == null) {
            throw new ExamenInvalidoExcepcion("No se puede registrar un examen nulo.");
        }

        examenRepositoryPort.guardar(examen);
    }
    
}