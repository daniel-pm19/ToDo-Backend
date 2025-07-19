package edu.workshop.todo.todo_console.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadisticaDTO {

    @Schema(description = "Cantidad total de tareas", example = "12")
    @Min(value = 0, message = "El número de tareas no puede ser negativo")
    private int tareas;

    @Schema(description = "Cantidad de tareas finalizadas", example = "7")
    @Min(value = 0, message = "El número de tareas finalizadas no puede ser negativo")
    private int tareasFinalizadas;
}
