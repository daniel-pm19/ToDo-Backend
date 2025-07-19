package edu.workshop.todo.todo_console.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
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
