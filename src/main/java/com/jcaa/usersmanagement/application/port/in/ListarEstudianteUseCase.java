package com.jcaa.usersmanagement.application.port.in;

import java.util.List;

import com.jcaa.usersmanagement.domain.model.Estudiante;

public interface ListarEstudianteUseCase {
    List<Estudiante> listarTodos();
}
