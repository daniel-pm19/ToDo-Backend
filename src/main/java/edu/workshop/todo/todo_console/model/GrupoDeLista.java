package edu.workshop.todo.todo_console.model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "grupodelistas")
public class GrupoDeLista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "grupodelistas_id")
    private List<ListaDeTarea> listasDeTareas;

    public GrupoDeLista() {
    }

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
        for (ListaDeTarea lista : listasDeTareas) {
            System.out.println(lista.getNombre());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<ListaDeTarea> getListasDeTareas() {
        return listasDeTareas;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

}
