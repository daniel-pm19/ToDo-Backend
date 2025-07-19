package edu.workshop.todo.todo_console.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Estado {
    COMPLETADA,
    PENDIENTE,
    INCOMPLETA;
}
