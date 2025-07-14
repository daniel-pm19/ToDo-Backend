package edu.workshop.todo.todo_console.mapper;

import edu.workshop.todo.todo_console.model.Historial;

import java.util.stream.Collectors;

import edu.workshop.todo.todo_console.dto.HistorialDTO;

public class HistorialMapper {
    public static Historial toEntity(HistorialDTO dto) {
        return Historial.builder()
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .tipoHistorial(dto.getTipoHistorial())
                .tareas(dto.getTareas().stream()
                        .map(TareaMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
