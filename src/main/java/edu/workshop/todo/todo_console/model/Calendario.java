package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class Calendario {

    private List<Tarea> tareas;

    public Calendario() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) throws ToDoException {
        if (tarea == null)
            throw new ToDoException(ToDoException.TAREA_INEXISTENTE);
        tareas.add(tarea);
    }

    public void eliminarTarea(Tarea tarea) throws ToDoException {
        if (tarea == null)
            throw new ToDoException(ToDoException.TAREA_INEXISTENTE);
        tareas.remove(tarea);
    }

    public void modificarTarea(Tarea tarea, String nombre, String descripcion, LocalDate fechaLimite, Estado estado,
            Prioridad prioridad) throws ToDoException {
        if (tarea == null)
            throw new ToDoException(ToDoException.TAREA_INEXISTENTE);
        tarea.modificarTarea(nombre, descripcion, fechaLimite, estado, prioridad);
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
}
