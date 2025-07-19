package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.model.enums.Prioridad;
import edu.workshop.todo.todo_console.model.enums.Estado;
import edu.workshop.todo.todo_console.service.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tareas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarea {
    @Id
    @Column
    @NotBlank(message = "ID cannot be blank")
    private Long id;

    @Column
    @NotBlank(message = "NOMBRE cannot be blank")
    @NotNull
    @Size(max = 20, message = "No puede exceder los 20 caracteres.")
    private String nombre;

    @Column
    @Size(max = 100, message = "No puede exceder los 100 caracteres.")
    private String descripcion;

    @Column
    @PastOrPresent
    private LocalDate fechaDeCreacion;

    @Column
    @Future
    private LocalDate fechaLimite;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tarea_id")
    private List<SubTarea> subtareas;

    @JoinColumn(name = "tarea_id")
    private List<Notificacion> notificaciones;
}
