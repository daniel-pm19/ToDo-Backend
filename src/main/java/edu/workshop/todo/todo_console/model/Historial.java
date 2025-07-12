package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.model.enums.TipoHistorial;
import edu.workshop.todo.todo_console.service.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "historial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "historial_id")
    private List<Tarea> tareas;

    @Enumerated(EnumType.STRING)
    private TipoHistorial tipoHistorial;

}
