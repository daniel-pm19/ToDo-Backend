package edu.workshop.todo.ToDo_maven.domain;

public enum Prioridad {
    ALTA("Alta"),
    MEDIA("Media"),
    BAJA("Baja");

    private String prioridad;

    Prioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public int getIndex() {
        return this.ordinal();
    }
}
