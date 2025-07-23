package edu.workshop.todo.todo_console.mapper;

import java.util.List;
import java.util.stream.Collectors;

import edu.workshop.todo.todo_console.model.SubTarea;
import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.dto.SubTareaDTO;
import edu.workshop.todo.todo_console.model.SubTarea;

public class SubTareaMapper {
    public static SubTarea toEntity(SubTareaDTO dto) {
        SubTarea subtarea = SubTarea.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .estado(dto.getEstado())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .build();

        Tarea tarea = new Tarea();
        tarea.setId(dto.getTarea_id());
        subtarea.setTarea(tarea);
        return subtarea;

    }

    public static SubTareaDTO toDTO(SubTarea subtarea) {
        return SubTareaDTO.builder()
                .id(subtarea.getId())
                .nombre(subtarea.getNombre())
                .estado(subtarea.getEstado())
                .fechaDeCreacion(subtarea.getFechaDeCreacion())
                .tarea_id(subtarea.getTarea().getId())
                .build();
    }

    public static List<SubTarea> toEntityList(List<SubTareaDTO> dtoList) {
        if (dtoList == null)
            return null;
        return dtoList.stream()
                .map(SubTareaMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static List<SubTareaDTO> toDTOList(List<SubTarea> entityList) {
        if (entityList == null)
            return null;
        return entityList.stream()
                .map(SubTareaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
