package edu.workshop.todo.todo_console.mapper;

import java.util.List;
import java.util.stream.Collectors;

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

    public static SubTareaDTO toDTO(SubTarea entity) {
        return SubTareaDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .estado(entity.getEstado())
                .fechaDeCreacion(entity.getFechaDeCreacion())
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
