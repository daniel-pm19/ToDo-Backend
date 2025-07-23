package edu.workshop.todo.todo_console.dto;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter

public class AuthResponseDTO {
    private String correoElectronico;
    private String nombre;
}
