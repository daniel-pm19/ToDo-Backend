package edu.workshop.todo.todo_console.dto;

import java.time.LocalDateTime;

import edu.workshop.todo.todo_console.model.enums.Estado;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubTareaDTO {

    @NotBlank(message = "id cannot be blank")
    private Long id;

    @NotBlank(message = "name cannot be blank")
    private String nombre;

    @NotBlank(message = "Estado cannot be blank")
    private Estado estado;

    @NotBlank(message = "fecha de creacion cannot be blank")
    private LocalDateTime fechaDeCreacion;

}
