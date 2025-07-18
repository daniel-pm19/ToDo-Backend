package edu.workshop.todo.todo_console.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseUsuarioDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String nombre;

    private String correoElectronico;

}
