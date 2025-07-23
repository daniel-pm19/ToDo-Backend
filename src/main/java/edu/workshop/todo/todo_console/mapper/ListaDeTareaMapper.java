package edu.workshop.todo.todo_console.mapper;

import java.util.stream.Collectors;
import java.util.List;
import edu.workshop.todo.todo_console.dto.ListaDeTareaDTO;
import edu.workshop.todo.todo_console.model.ListaDeTarea;
import edu.workshop.todo.todo_console.model.Usuarios;

public class ListaDeTareaMapper {

    public static ListaDeTarea toEntity(ListaDeTareaDTO dto) {
        ListaDeTarea listaDeTarea = ListaDeTarea.builder()
                .nombre(dto.getNombre())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .tareas(dto.getTareas().stream()
                        .map(TareaMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
        Usuarios usuario = new Usuarios();
        usuario.setId(dto.getUsuario_id());
        listaDeTarea.setUsuario(usuario);
        return listaDeTarea;
    }

    public static List<ListaDeTarea> toEntityList(List<ListaDeTareaDTO> dtoList) {
        if (dtoList == null)
            return null;
        return dtoList.stream()
                .map(ListaDeTareaMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static ListaDeTareaDTO toDTO(ListaDeTarea entity) {
        return ListaDeTareaDTO.builder()
                .nombre(entity.getNombre())
                .fechaDeCreacion(entity.getFechaDeCreacion())
                .tareas(entity.getTareas().stream()
                        .map(TareaMapper::toDTO)
                        .collect(Collectors.toList()))
                .usuario_id(entity.getUsuario().getId())
                .build();
    }

    public static List<ListaDeTareaDTO> toDTOList(List<ListaDeTarea> entityList) {
        if (entityList == null)
            return null;
        return entityList.stream()
                .map(ListaDeTareaMapper::toDTO)
                .collect(Collectors.toList());
    }

}
