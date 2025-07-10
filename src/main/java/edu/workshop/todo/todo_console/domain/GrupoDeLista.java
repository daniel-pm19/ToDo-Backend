package edu.workshop.todo.ToDo_maven.domain;

import java.util.ArrayList;
import java.time.LocalDate;

public class GrupoDeLista {
    private String nombre;
    private LocalDate fechaDeCreacion;
    private ArrayList<ListaDeTarea> listasDeTareas;

    public GrupoDeLista(String nombre, LocalDate fechaDeCreacion) {
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.listasDeTareas = new ArrayList<>();
    }

    public void agregarLista(ListaDeTarea lista) throws ToDoException {
        if (lista != null) {
            listasDeTareas.add(lista);
        } else {
            throw new ToDoException(ToDoException.LISTA_INEXISTENTE);
        }
    }

    public void eliminarLista(ListaDeTarea lista) throws ToDoException {
        if (lista != null && listasDeTareas.contains(lista)) {
            listasDeTareas.remove(lista);
        } else {
            throw new ToDoException(ToDoException.LISTA_INEXISTENTE);
        }
    }

    public void cambiarNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public void listarListas() {
        // Falta
    }

    public String getNombre() {
        return nombre;
    }

}
