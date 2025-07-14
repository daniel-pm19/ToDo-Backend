package edu.workshop.todo.todo_console.mapper;

import edu.workshop.todo.todo_console.dto.SubTareaDTO;
import edu.workshop.todo.todo_console.model.SubTarea;

public class SubTareaMapper {
    public static SubTarea toEntity(SubTareaDTO dto) {
        return SubTarea.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .estado(dto.getEstado())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .build();
    }
}
