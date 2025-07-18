package edu.workshop.todo.todo_console.mapper;

import edu.workshop.todo.todo_console.model.GrupoDeLista;

import java.util.stream.Collectors;
import java.util.List;

import edu.workshop.todo.todo_console.dto.GrupoDeListaDTO;

public class GrupoDeListaMapper {
    public static GrupoDeLista toEntity(GrupoDeListaDTO dto) {
        return GrupoDeLista.builder()
                .nombre(dto.getNombre())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .listasDeTareas(dto.getListaDeTareas().stream()
                        .map(ListaDeTareaMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static List<GrupoDeLista> toEntityList(List<GrupoDeListaDTO> dtoList) {
        if (dtoList == null)
            return null;
        return dtoList.stream()
                .map(GrupoDeListaMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static GrupoDeListaDTO toDTO(GrupoDeLista entity) {
        return GrupoDeListaDTO.builder()
                .nombre(entity.getNombre())
                .fechaDeCreacion(entity.getFechaDeCreacion())
                .listaDeTareas(entity.getListasDeTareas().stream()
                        .map(ListaDeTareaMapper::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public static List<GrupoDeListaDTO> toDTOList(List<GrupoDeLista> entityList) {
        if (entityList == null)
            return null;
        return entityList.stream()
                .map(GrupoDeListaMapper::toDTO)
                .collect(Collectors.toList());
    }

}