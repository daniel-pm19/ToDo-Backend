package edu.workshop.todo.todo_console.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;
import edu.workshop.todo.todo_console.dto.UsuarioRequestDTO;
import edu.workshop.todo.todo_console.dto.*;
import edu.workshop.todo.todo_console.exception.DuplicateResourceException;
import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.repository.UsuarioRepository;
import edu.workshop.todo.todo_console.service.TareaService;
import edu.workshop.todo.todo_console.service.UsuarioService;
import edu.workshop.todo.todo_console.mapper.*;
import edu.workshop.todo.todo_console.dto.EstadisticaDTO;
import org.springframework.transaction.annotation.Transactional;
import edu.workshop.todo.todo_console.service.impl.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j // LOGS
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TareaService tareaService;

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
        log.info("Creating a new user with ID: {}", dto.getId());

        if (usuarioRepository.existsById(dto.getId())) {
            throw DuplicateResourceException.create("User", "id", dto.getId());
        }

        if (usuarioRepository.findByEmail(dto.getCorreoElectronico()).isPresent()) {
            throw DuplicateResourceException.create("User", "id", dto.getCorreoElectronico());
        }

        Usuarios usuario = Usuarios.builder()
                .id(dto.getId())
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
                .build();
    }

    public TareaResponseDTO crearTarea(TareaRequestDTOO dto) {
        return tareaService.crearTarea(dto);
    }
}
