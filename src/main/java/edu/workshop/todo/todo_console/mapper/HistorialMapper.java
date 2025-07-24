package edu.workshop.todo.todo_console.mapper;

import edu.workshop.todo.todo_console.model.Historial;

import java.util.stream.Collectors;

import edu.workshop.todo.todo_console.dto.HistorialDTO;
import edu.workshop.todo.todo_console.model.Tarea;

import java.util.List;
import java.util.ArrayList;

public class HistorialMapper {
        public static Historial toEntity(HistorialDTO dto) {
                List<Tarea> tareas = dto.getTareas() != null 
                        ? dto.getTareas().stream()
                        .map(TareaMapper::toEntity)
                        .collect(Collectors.toList())
                        : new ArrayList<>();
                return Historial.builder()
                                .fechaDeCreacion(dto.getFechaDeCreacion())
                                .tipoHistorial(dto.getTipoHistorial())
                                .tareas(tareas)
                                .build();
        }

        public static HistorialDTO toDTO(Historial entity) {
                return HistorialDTO.builder()
                                .fechaDeCreacion(entity.getFechaDeCreacion())
                                .tipoHistorial(entity.getTipoHistorial())
                                .tareas(entity.getTareas().stream()
                                                .map(TareaMapper::toDTO)
                                                .collect(Collectors.toList()))
                                .build();
        }

}
