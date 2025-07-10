package edu.workshop.todo.ToDo_maven.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tarea {
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private LocalDate fechaLimite;
    private Estado estado;
    private Prioridad prioridad;
    private ArrayList<SubTarea> subtareas;
    private ArrayList<Notificacion> notificaciones;

    public Tarea(String newNombre, String newDescripcion, LocalDate newFechaDeCreacion, LocalDate newFechaLimite,
            Estado newEstado, Prioridad newPrioridad) {
        nombre = newNombre;
        descripcion = newDescripcion;
        fechaDeCreacion = newFechaDeCreacion;
        fechaLimite = newFechaLimite;
        estado = newEstado;
        prioridad = newPrioridad;
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
