package edu.workshop.todo.ToDo_maven.domain;

import java.time.LocalDateTime;

public class SubTarea {
    private String nombre;
    private Estado estado;
    private LocalDateTime fechaDeCreacion;

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
