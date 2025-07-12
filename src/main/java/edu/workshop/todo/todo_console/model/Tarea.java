package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "tareas")
public class Tarea {
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tarea_id")
    private List<Notificacion> notificaciones;

    public Tarea() {
    }

    public Tarea(String newNombre, String newDescripcion, LocalDate newFechaDeCreacion, LocalDate newFechaLimite,
            Estado newEstado, Prioridad newPrioridad) {
        nombre = newNombre;
        descripcion = newDescripcion;
        fechaDeCreacion = newFechaDeCreacion;
        fechaLimite = newFechaLimite;
        estado = newEstado;
        prioridad = newPrioridad;
        subtareas = new ArrayList<>();
        notificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado.getDescripcion();
    }

    public void agregarSubTarea(SubTarea subTarea) {
        subtareas.add(subTarea);
    }

    public void eliminarSubTarea(SubTarea subTarea) {
        subtareas.remove(subTarea);
    }

    public void modificarTarea(String newNombre, String newDescripcion, LocalDate newFechaLimite, Estado newEstado,
            Prioridad newPrioridad) {
        nombre = newNombre;
        descripcion = newDescripcion;
        fechaLimite = newFechaLimite;
        estado = newEstado;
        prioridad = newPrioridad;
    }

}
