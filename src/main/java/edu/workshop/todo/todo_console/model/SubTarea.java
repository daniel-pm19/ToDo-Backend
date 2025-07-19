package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.model.enums.*;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subtareas")
@Builder
@Data
public class SubTarea {
    @Id
    @Column
    @NotBlank(message = "ID cannot be blank")
    private Long id;

    @Column
    @NotBlank(message = "NOMBRE cannot be blank")
    @NotNull
    @Size(max = 20, message = "No puede exceder los 20 caracteres")
    private String nombre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column
    @NotNull(message = "La fecha No puede ser nula")
    @Past
    private LocalDateTime fechaDeCreacion;

}
