package edu.workshop.todo.todo_console.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estadisticas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estadistica {
    @Id
    @Column
    @NotBlank
    private Long id;
    @Column
    @NotBlank(message = "las tareas no pueden ser nulas")
    private int tareas;

    @Column
    @NotBlank(message = "tareas finalizadas no pueden ser nulas")
    private int tareasFinalizadas;
}
