package com.jcaa.usersmanagement.infrastructure.adapter;

import java.util.List;
import java.util.Scanner;
import java.util.Optional;

import com.jcaa.usersmanagement.application.port.in.RegistrarEstudianteUseCase;
import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;
import com.jcaa.usersmanagement.domain.model.Estudiante;

public class EstudianteCliAdapter {
   
    private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final EstudianteRepositoryPort repositoryPort; // Añadido para listar/buscar/eliminar directamente
    private final Scanner scanner;

    public EstudianteCliAdapter(RegistrarEstudianteUseCase registrarEstudianteUseCase, EstudianteRepositoryPort repositoryPort) {
        this.registrarEstudianteUseCase = registrarEstudianteUseCase;
        this.repositoryPort = repositoryPort;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE ALUMNOS (CLI) ---");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Listar Todos los Alumnos");
            System.out.println("3. Buscar Alumno por ID");
            System.out.println("4. Eliminar Alumno por ID");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Carrera: ");
                        String carrera = scanner.nextLine();

                        Estudiante nuevo = new Estudiante(id, nombre, apellido, email, carrera);
                        registrarEstudianteUseCase.registrar(nuevo);
                        
                        System.out.println("¡Alumno registrado con éxito en la tabla 'alumno'!");
                    } catch (Exception e) {
                        System.out.println("Error de negocio: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        List<Estudiante> alumnos = repositoryPort.findAll();
                        System.out.println("\n--- LISTA DE ALUMNOS ---");
                        if (alumnos.isEmpty()) {
                            System.out.println("No hay alumnos registrados.");
                        } else {
                            for (Estudiante a : alumnos) {
                                System.out.println("ID: " + a.getId() + " | " + a.getNombre() + " " + a.getApellido() + " | " + a.getEmail() + " | " + a.getCarrera());
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error al listar: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Ingrese el ID a buscar: ");
                        String searchId = scanner.nextLine();
                        Optional<Estudiante> encontrado = repositoryPort.findById(searchId);
                        if (encontrado.isPresent()) {
                            Estudiante a = encontrado.get();
                            System.out.println("Encontrado -> " + a.getNombre() + " " + a.getApellido() + " (" + a.getCarrera() + ")");
                        } else {
                            System.out.println("No se encontró ningún alumno con ese ID.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al buscar: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Ingrese el ID del alumno a eliminar: ");
                        String deleteId = scanner.nextLine();
                        repositoryPort.deleteById(deleteId);
                        System.out.println("Operación de eliminación ejecutada.");
                    } catch (Exception e) {
                        System.out.println("Error al eliminar: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
}
