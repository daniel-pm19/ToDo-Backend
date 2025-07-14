package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;
import edu.workshop.todo.todo_console.model.enums.TipoHistorial;
import edu.workshop.todo.todo_console.service.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "historial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Historial {
    @Id
    @Column
    @NotBlank(message = "ID cannot be blank")
    private Long id;

    @Column
    @NotNull(message = "La fecha No puede ser nula")
    @Past
    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "historial_id")
    private List<Tarea> tareas;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoHistorial tipoHistorial;

}
