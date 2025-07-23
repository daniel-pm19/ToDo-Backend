package edu.workshop.todo.todo_console.mapper;

import edu.workshop.todo.todo_console.model.GrupoDeLista;
import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.model.Usuarios;

import java.util.List;
import java.util.stream.Collectors;

import edu.workshop.todo.todo_console.dto.GrupoDeListaDTO;
import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;

public class TareaMapper {
        public static Tarea toEntity(TareaRequestDTOO dto) {
                Tarea tarea = Tarea.builder()
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
                Usuarios usuario = new Usuarios();
                usuario.setId(dto.getUsuario_id());
                tarea.setUsuario(usuario);
                return tarea;

        }

        public static TareaRequestDTOO toDTO(Tarea tarea) {
                return TareaRequestDTOO.builder()
                                .id(tarea.getId())
                                .nombre(tarea.getNombre())
                                .descripcion(tarea.getDescripcion())
                                .fechaDeCreacion(tarea.getFechaDeCreacion())
                                .fechaLimite(tarea.getFechaLimite())
                                .estado(tarea.getEstado())
                                .prioridad(tarea.getPrioridad())
                                .subtareas(tarea.getSubtareas().stream()
                                                .map(SubTareaMapper::toDTO)
                                                .collect(Collectors.toList()))
                                .usuario_id(tarea.getUsuario().getId())
                                .listaDeTarea_id(tarea.getListaDeTarea().getId())
                                .build();
        }

        public static List<TareaRequestDTOO> toDTOList(List<Tarea> entityList) {
                if (entityList == null)
                        return null;
                return entityList.stream()
                                .map(TareaMapper::toDTO)
                                .collect(Collectors.toList());
        }

        public static List<Tarea> toEntityList(List<TareaRequestDTOO> dtoList) {
                if (dtoList == null)
                        return null;

                return dtoList.stream()
                                .map(TareaMapper::toEntity)
                                .collect(Collectors.toList());
        }
}