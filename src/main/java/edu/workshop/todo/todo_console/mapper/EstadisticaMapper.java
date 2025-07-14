package edu.workshop.todo.todo_console.mapper;

import edu.workshop.todo.todo_console.model.Estadistica;
import edu.workshop.todo.todo_console.dto.EstadisticaDTO;

public class EstadisticaMapper {

    public static Estadistica toEntity(EstadisticaDTO dto) {
        return Estadistica.builder()
                .tareas(dto.getTareas())
                .tareasFinalizadas(dto.getTareasFinalizadas())
                .build();
    }
}
