package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;
import edu.workshop.todo.todo_console.model.enums.Estado;
import edu.workshop.todo.todo_console.model.enums.Prioridad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

@Entity
@Table(name = "historial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Calendario {
    @Id
    @Column
    @NotBlank
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "calendario_id")
    private List<Tarea> tareas;
}
