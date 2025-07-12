package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.model.enums.Prioridad;
import edu.workshop.todo.todo_console.model.enums.Estado;
import edu.workshop.todo.todo_console.service.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tar eas")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Tarea{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private LocalDate fechaLimite;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tarea_id")
    private List<SubTarea> subtareas;

    @JoinColumn(name = "tarea_id")
    private List<Notificacion> notificaciones;


}
