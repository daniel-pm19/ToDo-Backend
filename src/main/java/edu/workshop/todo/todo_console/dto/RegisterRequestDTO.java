package edu.workshop.todo.todo_console.dto;

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

public class RegisterRequestDTO {
    private String correoElectronico;
    private String nombre;
    private String contraseña;
}
