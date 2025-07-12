package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "historial_id")
    private List<Tarea> tareas;

    private TipoHistorial tipoHistorial;

    public Historial() {
    }

    public Historial(LocalDate newFechaDeCreacion) {
        fechaDeCreacion = newFechaDeCreacion;
        tipoHistorial = tipoHistorial.Todo;
        tareas = new ArrayList<>();
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public String historialTareas() {
        String historial = "";
        for (Tarea tarea : tareas) {
            historial += tarea.getNombre();
        }
        return historial;
    }

    public void cambiarTipo(TipoHistorial tipo) {
        tipoHistorial = tipo;
    }

}
