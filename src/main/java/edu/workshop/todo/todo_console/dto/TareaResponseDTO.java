package edu.workshop.todo.todo_console.dto;

import java.util.List;

import edu.workshop.todo.todo_console.model.*;
import edu.workshop.todo.todo_console.model.enums.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TareaResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private LocalDate fechaLimite;
    private Estado estado;
    private Prioridad prioridad;
    private List<SubTareaDTO> subtareas;
    private List<NotificacionDTO> notificaciones;
}
