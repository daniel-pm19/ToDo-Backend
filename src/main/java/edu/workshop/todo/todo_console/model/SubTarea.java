package edu.workshop.todo.todo_console.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "subtareas")
public class SubTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    private LocalDateTime fechaDeCreacion;

    public SubTarea() {
    }

    /**
     * Constructor
     */
    public SubTarea(String nuevoNombre, Estado nuevoEstado, LocalDateTime nuevaFechaDeCreacion) {
        nombre = nuevoNombre;
        estado = nuevoEstado;
        fechaDeCreacion = nuevaFechaDeCreacion;
    }

    /**
     * Modifica la SubTarea
     * 
     * @param nombre Nuevo Nombre.ArrayList
     * @param estado Nuevo estado de la tarea.
     */
    public void modificarSubTarea(String newNombre, Estado newEstado) {
        nombre = newNombre;
        estado = newEstado;
    }

    public void modificarEstado(Estado newEstado) {
        estado = newEstado;
    }

}
