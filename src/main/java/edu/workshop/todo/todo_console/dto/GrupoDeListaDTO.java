package edu.workshop.todo.todo_console.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrupoDeListaDTO {

    @Schema(description = "Nombre del grupo de listas", example = "Proyecto de fin de curso")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(max = 100, message = "El nombre no debe tener más de 100 caracteres")
    private String nombre;

    @Schema(description = "Fecha de creación del grupo", example = "2025-07-14")
    @NotNull(message = "La fecha de creación no puede ser nula")
    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate fechaDeCreacion;

    @Schema(description = "Listas de tareas asociadas a este grupo")
    private List<ListaDeTareaDTO> listaDeTareas;
}
