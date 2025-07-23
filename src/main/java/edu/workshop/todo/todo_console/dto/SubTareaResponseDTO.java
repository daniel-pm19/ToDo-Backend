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
public class SubTareaResponseDTO {

    private Long id;
    private String nombre;
    private Estado estado;
    private LocalDate fechaDeCreacion;
    private Long tarea_id;
}
