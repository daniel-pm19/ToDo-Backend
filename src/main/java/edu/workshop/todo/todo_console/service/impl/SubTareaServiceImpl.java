package edu.workshop.todo.todo_console.service.impl;

import org.springframework.stereotype.Service;

import edu.workshop.todo.todo_console.dto.*;
import edu.workshop.todo.todo_console.model.Notificacion;
import edu.workshop.todo.todo_console.model.SubTarea;
import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.repository.TareaRepository;
import edu.workshop.todo.todo_console.repository.SubTareaRepository;
import edu.workshop.todo.todo_console.service.SubTareaService;
import edu.workshop.todo.todo_console.mapper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import edu.workshop.todo.todo_console.exception.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubTareaServiceImpl implements SubTareaService {

    private final SubTareaRepository subTareaRepository;

    @Override
    @Transactional
    public SubTareaResponseDTO crearSubTarea(SubTareaDTO dto) {
        log.info("Creating a new SubTarea with ID: {}", dto.getId());

        SubTarea subtarea = SubTarea.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .estado(dto.getEstado())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .build();
        Tarea tarea = new Tarea();
        tarea.setId(dto.getTarea_id());
        subtarea.setTarea(tarea);
        SubTarea savedSubTareas = subTareaRepository.save(subtarea);
        return mapToDto(savedSubTareas);
    }

    @Override
    @Transactional
    public void eliminarSubTarea(Long id) {
        log.info("Deleting SUBTAREA with ID: {}", id);
        subTareaRepository.deleteById(id);
        log.info("TAREA deleted successfully: {}", id);
    }

    public SubTareaResponseDTO mapToDto(SubTarea subtarea) {
        return SubTareaResponseDTO.builder()
                .id(subtarea.getId())
                .nombre(subtarea.getNombre())
                .fechaDeCreacion(subtarea.getFechaDeCreacion())
                .estado(subtarea.getEstado())
                .tarea_id(subtarea.getTarea().getId())
                .build();
    }

}