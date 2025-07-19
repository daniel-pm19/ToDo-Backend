package edu.workshop.todo.todo_console.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificacionDTO {

    @NotNull(message = "El titulo no puede ser nulo")
    @Schema(description = "Titulo de la notificacion", example = "La tarea ejemplo se encuentra proxima a vencerse")
    private String titulo;

    @NotNull(message = "El mensaje no puede ser nulo")
    @Schema(description = "Mensaje de la notificacion", example = "La tarea ejemplo se vencera en 2 dias a el dia 13-08-25")
    private String mensaje;

    @NotNull(message = "La fecha de creacion no puede ser nula")
    @Schema(description = "Fecha de creacion de la notificacion", example = "13-07-25")
    private LocalDate fechaDeCreacion;

}
