package edu.workshop.todo.ToDo_maven.domain;

import java.time.LocalDate;
import java.util.HashMap;

public class ListaDeTarea {
    private String nombre;
    private LocalDate fechaDeCreacion;
    private HashMap<String, Tarea> tareas;

    public ListaDeTarea(String newNombre, LocalDate newFechaDeCreacion) {
        nombre = newNombre;
        fechaDeCreacion = newFechaDeCreacion;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.put(tarea.getNombre(), tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea.getNombre());
    }

    public void cambiarNombre(String newNombre) {
        nombre = newNombre;
    }

    public int tareasCompletadas() {
        int cantidad = 0;
        for (Tarea tarea : tareas.values()) {
            if (tarea.getEstado().equals("Completado")) {
                cantidad += 1;
            }
        }
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

}