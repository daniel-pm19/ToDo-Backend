package edu.workshop.todo.ToDo_maven.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Historial {
    private LocalDate fechaDeCreacion;
    private ArrayList<Tarea> tareas;
    private TipoHistorial tipoHistorial;

    public Historial(LocalDate newFechaDeCreacion) {
        fechaDeCreacion = newFechaDeCreacion;
        tipoHistorial = tipoHistorial.Todo;
        tareas = new ArrayList<>();
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public String historialTareas(){
        String historial = "";
        for (Tarea tarea : tareas){
            historial += tarea.getNombre();
        }
        return historial;
    }

    public void  cambiarTipo(TipoHistorial tipo){
        tipoHistorial = tipo;
    }

}
