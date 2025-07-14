package edu.workshop.todo.todo_console.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import edu.workshop.todo.todo_console.model.enums.TipoHistorial;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorialDTO {

    @NotNull(message = "La fecha de creación no puede ser nula")
    @Schema(description = "Fecha en la que se creó el historial", example = "2025-07-12")
    private LocalDate fechaDeCreacion;

    @NotNull(message = "El tipo de historial no puede ser nulo")
    @Schema(description = "Tipo del historial", example = "CAMBIO_ESTADO")
    private TipoHistorial tipoHistorial;

    @Schema(description = "Lista de tareas asociadas al historial")
    private List<TareaRequestDTOO> tareas;
}
