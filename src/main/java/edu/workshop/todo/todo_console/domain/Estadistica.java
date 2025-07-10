package edu.workshop.todo.ToDo_maven.domain;

public class Estadistica {
    private int tareas;
    private int tareasFinalizadas;

    public Estadistica(int newTareas, int newTareasFinalizadas) {
        tareas = newTareas;
        tareasFinalizadas = newTareasFinalizadas;
    }

    public double generarEstadistica() {
        return tareasFinalizadas / tareas;
    }

    public void plusTareas() {
        tareas++;
    }

    public void plusTareasFinalizadas() {
        tareasFinalizadas++;
    }
    // Inicialmente hay 0 - 0, con el paso del tiempo las tareas van a aumentar?

    public String mostrarEstadistica() {
        return String.valueOf(generarEstadistica()) + "%";
    }
}
