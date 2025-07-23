package edu.workshop.todo.todo_console.dto;

import java.time.LocalDate;
import java.util.List;

import edu.workshop.todo.todo_console.model.enums.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrupoDeListaResponseDTO {

    private Long id;

    @Schema(description = "Nombre del grupo de listas", example = "Proyecto de fin de curso")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(max = 100, message = "El nombre no debe tener más de 100 caracteres")
    private String nombre;

    @Schema(description = "Fecha de creación del grupo", example = "2025-07-14")
    @NotNull(message = "La fecha de creación no puede ser nula")
    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate fechaDeCreacion;

    private List<ListaDeTareaDTO> listaDeTareas;

    @Schema(description = "id del Usuario")
    private Long usuario_id;
}
