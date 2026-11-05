package com.jcaa.usersmanagement.application.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;
import com.jcaa.usersmanagement.domain.exception.EstudianteInvalidoExcepcion;
import com.jcaa.usersmanagement.domain.model.Estudiante;

public class RegistrarEstudianteServiceTest {
    private EstudianteRepositoryPort repositoryPort;
    private RegistrarEstudianteService service;

    @BeforeEach
    void setUp() {
        repositoryPort = Mockito.mock(EstudianteRepositoryPort.class);
        service = new RegistrarEstudianteService(repositoryPort);
    }

    @Test
    void dadoEstudianteNuevo_cuandoSeRegistra_entoncesGuardaExitosamente() {
        Estudiante nuevo = new Estudiante("E01", "Gabriel", "Montoya", "gmontoya@uchile.com", "Ingenieria Civil");
        when(repositoryPort.findById("E01")).thenReturn(Optional.empty());
        when(repositoryPort.findByEmail("gmontoya@uchile.com")).thenReturn(Optional.empty());

        assertDoesNotThrow(() -> service.registrar(nuevo));
        verify(repositoryPort, times(1)).save(nuevo);
    }

    @Test
    void dadoIdExistente_cuandoSeRegistra_entoncesLanzaExcepcion() {
        Estudiante existente = new Estudiante("E01", "Luis", "Gómez", "gmontoya@uchile.com", "Ingenieria Civil");
        when(repositoryPort.findById("E01")).thenReturn(Optional.of(existente));

        assertThrows(EstudianteInvalidoExcepcion.class, () -> {
            service.registrar(existente);
        });
        verify(repositoryPort, never()).save(any());
    }
}
