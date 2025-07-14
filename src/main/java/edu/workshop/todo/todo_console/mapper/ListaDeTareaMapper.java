package edu.workshop.todo.todo_console.mapper;

import java.util.stream.Collectors;
import java.util.List;
import edu.workshop.todo.todo_console.dto.ListaDeTareaDTO;
import edu.workshop.todo.todo_console.model.ListaDeTarea;

public class ListaDeTareaMapper {

    public static ListaDeTarea toEntity(ListaDeTareaDTO dto) {
        return ListaDeTarea.builder()
                .nombre(dto.getNombre())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .tareas(dto.getTareas().stream()
                        .map(TareaMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static List<ListaDeTarea> toEntityList(List<ListaDeTareaDTO> dtoList) {
        if (dtoList == null)
            return null;
        return dtoList.stream()
                .map(ListaDeTareaMapper::toEntity)
                .collect(Collectors.toList());
    }

}
