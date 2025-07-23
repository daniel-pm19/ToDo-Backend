package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.model.enums.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subtareas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubTarea {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate fechaDeCreacion;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

}
