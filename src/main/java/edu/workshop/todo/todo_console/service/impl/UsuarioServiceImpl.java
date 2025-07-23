package edu.workshop.todo.todo_console.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.workshop.todo.todo_console.dto.*;
import edu.workshop.todo.todo_console.exception.DuplicateResourceException;
import edu.workshop.todo.todo_console.exception.ResourceNotFoundException;
import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.repository.UsuarioRepository;
import edu.workshop.todo.todo_console.service.TareaService;
import edu.workshop.todo.todo_console.service.UsuarioService;
import edu.workshop.todo.todo_console.mapper.*;

import org.springframework.transaction.annotation.Transactional;
import edu.workshop.todo.todo_console.service.impl.*;
import jakarta.faces.application.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j // LOGS
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TareaService tareaService;

    @Override
    @Transactional
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
        log.info("Creating a new user with Name: {}", dto.getNombre());
        if (usuarioRepository.findByCorreoElectronico(dto.getCorreoElectronico()).isPresent()) {
            throw DuplicateResourceException.create("User", "id", dto.getCorreoElectronico());
        }

        Usuarios usuario = Usuarios.builder()
                .nombre(dto.getNombre())
                .correoElectronico(dto.getCorreoElectronico())
                .contraseña(dto.getContraseña())
                .estadistica(EstadisticaMapper.toEntity(dto.getEstadistica()))
                .historial(HistorialMapper.toEntity(dto.getHistorial()))
                .notificaciones(NotificacionMapper.toEntityList(dto.getNotificaciones()))
                .calendario(CalendarioMapper.toEntity(dto.getCalendario()))
                .grupoDeListas(GrupoDeListaMapper.toEntityList(dto.getGrupoDelistas()))
                .listaDeTareas(ListaDeTareaMapper.toEntityList(dto.getListaDeTareas()))
                .build();

        Usuarios savedUsuarios = usuarioRepository.save(usuario);
        return mapToDto(savedUsuarios);
    }

    public UsuarioResponseDTO mapToDto(Usuarios usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .correoElectronico(usuario.getCorreoElectronico())
                .estadistica(EstadisticaMapper.toDTO(usuario.getEstadistica()))
                .historial(HistorialMapper.toDTO(usuario.getHistorial()))
                .notificaciones(NotificacionMapper.toDTOList(usuario.getNotificaciones()))
                .calendario(CalendarioMapper.toDTO(usuario.getCalendario()))
                .grupoDeListas(GrupoDeListaMapper.toDTOList(usuario.getGrupoDeListas()))
                .listaDeTareas(ListaDeTareaMapper.toDTOList(usuario.getListaDeTareas()))
                .tareas(TareaMapper.toDTOList(usuario.getTareas()))
                .build();
    }

    public void eliminarUsuario(Long id) {
        log.info("Deleting User with ID: {}", id);
        if (!usuarioRepository.existsById(id)) {
            throw ResourceNotFoundException.create("ID", id);
        }
        usuarioRepository.deleteById(id);
        log.info("Usuer Deleted successfully: {}", id);
    }

    public UsuarioResponseDTO updateUsuario(Long id, UsuarioRequestDTO dto) {
        log.info("Updating User with id: {}", id);
        Usuarios usuario = usuarioRepository.findById(id).orElseThrow(() -> ResourceNotFoundException.create("ID", id));
        usuario.setNombre(dto.getNombre());
        usuario.setCorreoElectronico(dto.getCorreoElectronico());
        usuario.setEstadistica(EstadisticaMapper.toEntity(dto.getEstadistica()));
        usuario.setHistorial(HistorialMapper.toEntity(dto.getHistorial()));
        usuario.setNotificaciones(NotificacionMapper.toEntityList(dto.getNotificaciones()));
        usuario.setCalendario(CalendarioMapper.toEntity(dto.getCalendario()));
        usuario.setGrupoDeListas(GrupoDeListaMapper.toEntityList(dto.getGrupoDelistas()));
        usuario.setListaDeTareas(ListaDeTareaMapper.toEntityList(dto.getListaDeTareas()));

        Usuarios savedUsuario = usuarioRepository.save(usuario);
        return mapToDto(savedUsuario);
    }

    public UsuarioResponseDTO getUsuarioById(Long id) {
        Usuarios usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.create("User", id));

        return mapToDto(usuario);
    }

    public UsuarioResponseDTO getUsuarioByEmail(String email) {
        log.info("Retrieving user with email: {}", email);

        Usuarios usuario = usuarioRepository.findByCorreoElectronico(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));

        return mapToDto(usuario);
    }

    public List<UsuarioResponseDTO> getAllUsuarios() {
        List<Usuarios> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::mapToDto)
                .toList();
    }
}
