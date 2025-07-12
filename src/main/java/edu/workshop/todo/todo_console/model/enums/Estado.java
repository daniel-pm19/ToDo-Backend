package edu.workshop.todo.todo_console.domain;

public enum Estado {
    COMPLETADA("Completado"),
    PENDIENTE("Pendiente"),
    INCOMPLETA("Incompleta");

    private final String descripcion;

    Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIndex() {
        return this.ordinal();
    }
}
