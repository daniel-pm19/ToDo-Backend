package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "listadetareas")
public class ListaDeTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "listadetareas_id")
    private List<Tarea> tareas;

    public ListaDeTarea() {
    }

    public ListaDeTarea(String newNombre, LocalDate newFechaDeCreacion) {
        nombre = newNombre;
        fechaDeCreacion = newFechaDeCreacion;
        tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea);
    }

    public void cambiarNombre(String newNombre) {
        nombre = newNombre;
    }

    public int tareasCompletadas() {
        int cantidad = 0;
        for (Tarea tarea : tareas) {
            if (tarea.getEstado().equals("Completado")) {
                cantidad += 1;
            }
        }
        return cantidad;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getNombre() {
        return nombre;
    }

}