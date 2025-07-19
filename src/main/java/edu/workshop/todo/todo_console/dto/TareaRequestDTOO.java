package edu.workshop.todo.todo_console.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.experimental.SuperBuilder;
import lombok.*;
import java.lang.*;

import edu.workshop.todo.todo_console.model.*;
import edu.workshop.todo.todo_console.model.enums.*;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TareaRequestDTOO {

    @Schema(description = "ID único de la tarea", example = "123")
    @NotNull(message = "id no puede ser nulo")
    private Long id;

    @Schema(description = "Nombre de la tarea", example = "Hacer el informe")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Schema(description = "Descripción de la tarea", example = "Escribir y entregar el informe mensual")
    private String descripcion;

    @Schema(description = "Fecha de creación", example = "2025-07-13")
    private LocalDate fechaDeCreacion;

    @Schema(description = "Fecha límite de entrega", example = "2025-07-20")
    private LocalDate fechaLimite;

    @Schema(description = "Estado actual de la tarea", example = "EN_PROGRESO")
    private Estado estado;

    @Schema(description = "Nivel de prioridad de la tarea", example = "ALTA")
    private Prioridad prioridad;

    @Schema(description = "Lista de subtareas asociadas")
    private List<SubTareaDTO> subtareas;

    @Schema(description = "Lista de notificaciones configuradas")
    private List<NotificacionDTO> notificaciones;

}
