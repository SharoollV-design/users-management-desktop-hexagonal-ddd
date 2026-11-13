package com.jcaa.usersmanagement.infrastructure.adapter.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jcaa.usersmanagement.domain.model.Estudiante;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity.EstudianteEntity;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper.EstudianteMapper;
import com.jcaa.usersmanagement.application.port.out.EstudianteRepositoryPort;

public class MySQLEstudianteRepositoryAdapter implements  EstudianteRepositoryPort{

    @Override
    public void save(Estudiante estudiante) {
        EstudianteEntity entity = EstudianteMapper.toEntity(estudiante);
        
        // Consultas apuntando a tu tabla ALUMNO y sus columnas reales
        String sql = "INSERT INTO ALUMNO (id_codigo, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo, identificacion) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "primer_nombre = VALUES(primer_nombre), " +
                     "segundo_nombre = VALUES(segundo_nombre), " +
                     "primer_apellido = VALUES(primer_apellido), " +
                     "segundo_apellido = VALUES(segundo_apellido), " +
                     "correo = VALUES(correo), " +
                     "identificacion = VALUES(identificacion)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, entity.getId());
            pstmt.setString(2, entity.getNombre()); // O el campo correspondiente de tu entidad
            pstmt.setString(3, ""); // segundo_nombre (si lo manejas en blanco o en la entidad)
            pstmt.setString(4, entity.getApellido()); // primer_apellido
            pstmt.setString(5, ""); // segundo_apellido
            pstmt.setString(6, entity.getEmail()); // correo
            pstmt.setString(7, entity.getId()); // identificacion (o el valor que uses)
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar en MySQL: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Estudiante> findById(String id) {
        // Buscamos por la llave primaria real: id_codigo
        String sql = "SELECT id_codigo, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo, identificacion " +
                     "FROM ALUMNO WHERE id_codigo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Mapeamos uniendo el primer nombre y apellido para que encaje con el dominio
                String nombreCompleto = rs.getString("primer_nombre");
                String apellidoCompleto = rs.getString("primer_apellido");
                
                EstudianteEntity entity = new EstudianteEntity(
                    rs.getString("id_codigo"),
                    nombreCompleto,
                    apellidoCompleto,
                    rs.getString("correo"),
                    "General" // Valor por defecto ya que la tabla no tiene carrera
                );
                return Optional.of(EstudianteMapper.toDomain(entity));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar por ID en MySQL: " + e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Estudiante> findByEmail(String email) {
        // Buscamos por correo en lugar de email
        String sql = "SELECT id_codigo, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo, identificacion " +
                     "FROM ALUMNO WHERE correo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                EstudianteEntity entity = new EstudianteEntity(
                    rs.getString("id_codigo"),
                    rs.getString("primer_nombre"),
                    rs.getString("primer_apellido"),
                    rs.getString("correo"),
                    "General"
                );
                return Optional.of(EstudianteMapper.toDomain(entity));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar por correo en MySQL: " + e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public List<Estudiante> findAll() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT id_codigo, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo, identificacion FROM ALUMNO";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                EstudianteEntity entity = new EstudianteEntity(
                    rs.getString("id_codigo"),
                    rs.getString("primer_nombre"),
                    rs.getString("primer_apellido"),
                    rs.getString("correo"),
                    "General"
                );
                lista.add(EstudianteMapper.toDomain(entity));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar alumnos desde MySQL: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deleteById(String id) {
        // Eliminamos usando id_codigo
        String sql = "DELETE FROM ALUMNO WHERE id_codigo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar alumno en MySQL: " + e.getMessage(), e);
        }
    }
}
