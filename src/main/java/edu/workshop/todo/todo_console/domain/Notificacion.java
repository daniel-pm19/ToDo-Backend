package edu.workshop.todo.ToDo_maven.domain;

import java.time.LocalDate;

public class Notificacion {
    private String titulo;
    private String mensaje;
    private LocalDate fechaDeCreacion;

    public Notificacion(String newTitulo, String newMensaje, LocalDate newFechaDeCreacion) {
        titulo = newTitulo;
        mensaje = newMensaje;
        fechaDeCreacion = newFechaDeCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }
}
