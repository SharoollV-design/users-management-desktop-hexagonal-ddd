package com.jcaa.usersmanagement;

import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;
import com.jcaa.usersmanagement.application.service.RegistrarEstudianteService;
import com.jcaa.usersmanagement.infrastructure.adapter.EstudianteCliAdapter;
import com.jcaa.usersmanagement.infrastructure.config.DependencyContainer;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.UserManagementCli;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcaa.usersmanagement.infrastructure.adapter.persistence.MySQLEstudianteRepositoryAdapter;

public final class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
        log.info("Starting Users Management System...");

        try {
            EstudianteRepositoryPort repositoryPort = new MySQLEstudianteRepositoryAdapter();
            RegistrarEstudianteService registrarService = new RegistrarEstudianteService(repositoryPort);
            
            // Pasamos ambos para soportar todas las opciones del menú
            EstudianteCliAdapter cliAdapter = new EstudianteCliAdapter(registrarService, repositoryPort);

            cliAdapter.mostrarMenu();

        } catch (Exception e) {
            log.error("Error al iniciar la aplicación: {}", e.getMessage(), e);
        }
    }
}