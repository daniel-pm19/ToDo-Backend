package edu.workshop.todo.todo_console.mapper;

import edu.workshop.todo.todo_console.model.Tarea;

import java.util.stream.Collectors;

import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;

public class TareaMapper {
    public static Tarea toEntity(TareaRequestDTOO dto) {
        return Tarea.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .fechaLimite(dto.getFechaLimite())
                .estado(dto.getEstado())
                .prioridad(dto.getPrioridad())
                .subtareas(dto.getSubtareas().stream()
                        .map(SubTareaMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
