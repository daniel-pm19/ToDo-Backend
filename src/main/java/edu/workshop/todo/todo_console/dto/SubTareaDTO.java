package edu.workshop.todo.todo_console.dto;

import java.time.LocalDate;

import edu.workshop.todo.todo_console.model.enums.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

// SUBTAREA REQUEST
public class SubTareaDTO {

    private Long id;

    @NotBlank(message = "name cannot be blank")
    private String nombre;

    @NotBlank(message = "Estado cannot be blank")
    private Estado estado;

    @NotBlank(message = "fecha de creacion cannot be blank")
    private LocalDate fechaDeCreacion;

    @Schema(description = "Id de la tarea")
    private Long tarea_id;

}
