package edu.workshop.todo.todo_console.service.impl;

import org.springframework.stereotype.Service;

import edu.workshop.todo.todo_console.dto.*;
import edu.workshop.todo.todo_console.model.Notificacion;
import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.repository.TareaRepository;
import edu.workshop.todo.todo_console.service.TareaService;
import edu.workshop.todo.todo_console.mapper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import edu.workshop.todo.todo_console.exception.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;

    @Override
    @Transactional(readOnly = true)
    public TareaResponseDTO crearTarea(TareaRequestDTOO dto) {
        log.info("Creating a new user with ID: {}", dto.getId());

        if (tareaRepository.findByName(dto.getNombre()).isEmpty()) {
            throw DuplicateResourceException.create("Tarea", "Nombre", dto.getNombre());
        }
        if (tareaRepository.findByPrioridad(dto.getPrioridad()).isEmpty()) {
            throw DuplicateResourceException.create("Tarea", "Prioridad", dto.getPrioridad());
        }
        if (tareaRepository.findByEstado(dto.getEstado()).isEmpty()) {
            throw DuplicateResourceException.create("Tarea", "Estado", dto.getEstado());
        }

        Tarea tarea = Tarea.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .fechaLimite(dto.getFechaLimite())
                .estado(dto.getEstado())
                .prioridad(dto.getPrioridad())
                .subtareas(SubTareaMapper.toEntityList(dto.getSubtareas()))
                .notificaciones(NotificacionMapper.toEntityList(dto.getNotificaciones()))
                .build();

        Tarea savedTareas = tareaRepository.save(tarea);
        return mapToDto(savedTareas);
    }

    @Override
    @Transactional
    public void eliminarTarea(Long id) {
        log.info("DeletingTAREA with ID: {}", id);

        if (!tareaRepository.existsById(id)) {
            throw ResourceNotFoundException.create("ID", id);
        }

        tareaRepository.deleteById(id);
        log.info("TAREA deleted successfully: {}", id);
    }

    public TareaResponseDTO updateTarea(Long id, TareaRequestDTOO dto) {
        log.info("Updating Homework with name: {}", id);

        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.create("ID", id));

        tarea.setNombre(dto.getNombre());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setFechaDeCreacion(dto.getFechaDeCreacion());
        tarea.setFechaLimite(dto.getFechaLimite());
        tarea.setEstado(dto.getEstado());
        tarea.setPrioridad(dto.getPrioridad());
        tarea.setSubtareas(SubTareaMapper.toEntityList(dto.getSubtareas()));
        tarea.setNotificaciones(NotificacionMapper.toEntityList(dto.getNotificaciones()));

        Tarea savedTarea = tareaRepository.save(tarea);
        return mapToDto(savedTarea);
    }

    public TareaResponseDTO mapToDto(Tarea tarea) {
        return TareaResponseDTO.builder()
                .id(tarea.getId())
                .nombre(tarea.getNombre())
                .descripcion(tarea.getDescripcion())
                .fechaDeCreacion(tarea.getFechaDeCreacion())
                .fechaLimite(tarea.getFechaLimite())
                .estado(tarea.getEstado())
                .prioridad(tarea.getPrioridad())
                .build();
    }

    public TareaResponseDTO getTareaById(Long id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.create("Tarea", id));

        return mapToDto(tarea);
    }
}