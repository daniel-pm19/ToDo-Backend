package edu.workshop.todo.todo_console.mapper;

import edu.workshop.todo.todo_console.model.*;
import edu.workshop.todo.todo_console.dto.*;
import lombok.*;
import java.util.*;
import java.util.stream.Collectors;

public class NotificacionMapper {
    public static Notificacion toEntity(NotificacionDTO dto) {
        return Notificacion.builder()
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .mensaje(dto.getMensaje())
                .titulo(dto.getTitulo())
                .build();
    }

    public static List<Notificacion> toEntityList(List<NotificacionDTO> dtoList) {
        if (dtoList == null)
            return null;
        return dtoList.stream()
                .map(NotificacionMapper::toEntity)
                .collect(Collectors.toList());
    }
}
