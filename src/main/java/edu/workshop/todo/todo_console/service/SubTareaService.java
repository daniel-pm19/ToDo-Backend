package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.*;

public interface SubTareaService {
    SubTareaResponseDTO crearSubTarea(SubTareaDTO dto);

    void eliminarSubTarea(Long id);
}
