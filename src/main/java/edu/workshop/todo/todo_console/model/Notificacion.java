package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacion {
    @Id
    @Column
    @NotBlank
    private Long id;

    @Column(nullable = false)
    @Size(max = 100, message = "La máxima longitud del titulo es 100 caracteres")
    private String titulo;

    @Column(nullable = false)
    @Size(max = 100, message = "La máxima longitud del mensaje es 100 caracteres")
    private String mensaje;

    @Column
    @NotNull(message = "La fecha No puede ser nula")
    @PastOrPresent
    private LocalDate fechaDeCreacion;
}
