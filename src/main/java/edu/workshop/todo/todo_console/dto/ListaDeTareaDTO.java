package edu.workshop.todo.todo_console.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// REQUEST
public class ListaDeTareaDTO {

    private Long id;

    @Schema(description = "Nombre de la lista de tareas", example = "Lista de compras")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(max = 100, message = "El nombre no debe contener más de 100 caracteres")
    private String nombre;

    @Schema(description = "Fecha de creación de la lista", example = "2025-07-14")
    @NotNull(message = "La fecha de creación no puede ser nula")
    private LocalDate fechaDeCreacion;

    @Schema(description = "Lista de tareas asociadas")
    private List<TareaRequestDTOO> tareas;

    private Long usuario_id;

    private Long grupoDeLista_id;

}
