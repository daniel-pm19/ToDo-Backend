package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.*;

public interface TareaService {
    TareaResponseDTO crearTarea(TareaRequestDTOO dto);

    void eliminarTarea(Long id);

    TareaResponseDTO updateTarea(Long id, TareaRequestDTOO dto);

    TareaResponseDTO getTareaById(Long id);

}
